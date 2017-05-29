package com.kodeveloper.food.web.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yaksaa on 2017/05/29.
 */
@Controller
public class SampleController {

    @Autowired
//    private CustomerRepository repository;

    @RequestMapping(path = "/mongo")
    public void mongo () {
        System.out.println(11111);
    }

}
