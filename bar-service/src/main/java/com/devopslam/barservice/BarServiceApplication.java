package com.devopslam.barservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BarServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarServiceApplication.class, args);
	}

	private final Logger logger = LoggerFactory.getLogger(BarServiceApplication.class);
	
	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}

	@GetMapping
	public String index() {
		logger.info("Someone is coming. Hi stranger");
		return "Someone is coming. Hi stranger";
	}
}
