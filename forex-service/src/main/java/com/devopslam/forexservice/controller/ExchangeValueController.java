package com.devopslam.forexservice.controller;

import com.devopslam.forexservice.model.ExchangeValue;
import com.devopslam.forexservice.service.ExchangeValueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = ExchangeValueController.EXCHANGE_VALUE_URI)
public class ExchangeValueController {

    private static final Logger logger = LoggerFactory.getLogger(ExchangeValueController.class);

    public static final String EXCHANGE_VALUE_URI = "/currency-exchange";

    @Autowired
    private ExchangeValueService exService;

    @Autowired
    private Environment environment;

    @GetMapping()
    public String index() {
        return "Hello, I'm the Forex Service";
    }

    @GetMapping("/from/{from}/to/{to}")
    public ResponseEntity<Object> retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        logger.info("Retrieve Exchange value: from {} to {}", from, to);
        Optional<ExchangeValue> exchangeValue = exService.getFromAndTo(from, to);
        if (!exchangeValue.isPresent()) return new ResponseEntity<>("Not found", HttpStatus.BAD_REQUEST);
        ExchangeValue localEx = exchangeValue.map(ex -> {
            ex.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
            return ex;
        }).get();
        return new ResponseEntity<>(localEx, HttpStatus.OK);
    }
}
