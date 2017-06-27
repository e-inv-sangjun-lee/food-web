package com.kodeveloper.food.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LEESANGJUN on 2017/06/27.
 */

@Controller
@RequestMapping(path = "/setup")
public class SetupController {

    @RequestMapping(path = {"", "/", "/index"})
    public String setupIndex() {
        return "setup-index";
    }
}
