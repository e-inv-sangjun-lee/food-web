package com.kodeveloper.food.web.sample;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private CustomerRepository repository;

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
