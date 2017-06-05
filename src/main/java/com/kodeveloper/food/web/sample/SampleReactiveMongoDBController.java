package com.kodeveloper.food.web.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by yaksaa on 2017/06/06.
 */
@RestController
@RequestMapping(path = "/reactivemongo")
public class SampleReactiveMongoDBController {

    private ReactiveCustomerRepository repository;

    public SampleReactiveMongoDBController (ReactiveCustomerRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(path = "/save")
    public Mono<Customer> save () {
        return repository.save(new Customer(
                "reactive kodeveloper",
                DateTimeFormatter.ofPattern("MMddHHmmss").format(LocalDateTime.now())));
    }

    @RequestMapping(path = "/findAll")
    public Flux<Customer> findAll() {
        return repository.findAll();
    }
}
