package com.kodeveloper.food.web.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by yaksaa on 2017/05/29.
 */
@RestController
@RequestMapping(path = "/mongo")
public class SampleMongoDBController {

    private CustomerRepository repository;

    public SampleMongoDBController (CustomerRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(path = "/save")
    public Customer save () {
        return repository.save(new Customer(
                "kodeveloper",
                DateTimeFormatter.ofPattern("MMddHHmmss").format(LocalDateTime.now())));
    }

    @RequestMapping(path = "/findAll")
    public List<Customer> findAll() {
        return repository.findAll();
    }
}
