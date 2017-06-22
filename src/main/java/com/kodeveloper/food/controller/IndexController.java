package com.kodeveloper.food.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

@Controller
public class IndexController {

    private final String [] messages = {"H", "e", "l", "l", "o", " ", "w", "o", "r", "l", "d", "!"};

    @RequestMapping("/")
    String index(final Model model) {
        model.addAttribute("messages", new ReactiveDataDriverContextVariable(Flux.just(messages)));
        return "index";
    }
}
