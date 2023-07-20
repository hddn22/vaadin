package com.example.test.service;

import com.example.test.Entity.Counter;
import com.example.test.repository.CounterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CounterService {
    CounterRepository counterRepository;

    public Optional<Counter> findById(Long id){
        return counterRepository.findById(id);
    }

    public void save(Counter counter) {
        counterRepository.save(counter);
    }
}
