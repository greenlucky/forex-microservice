package com.devopslam.forexservice.service;

import com.devopslam.forexservice.model.ExchangeValue;
import com.devopslam.forexservice.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ExchangeValueService {

    @Autowired
    private ExchangeValueRepository exRepository;

    public Optional<ExchangeValue> getFromAndTo(String from, String to) {
        return exRepository.findByFromAndTo(from, to);

    }
}
