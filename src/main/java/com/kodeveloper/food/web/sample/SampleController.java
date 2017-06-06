package com.kodeveloper.food.web.sample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

/**
 * Created by yaksaa on 2017/05/29.
 */
@Controller
public class SampleController {

    private final String [] messages = {"H", "e", "l", "l", "o", " ", "w", "o", "r", "l", "d", "!"};

    @RequestMapping("/")
    String index(final Model model) {
        model.addAttribute("messages", messages);
        return "index";
    }

    @RequestMapping("/reactive")
    String reactiveIndex(final Model model) {
        model.addAttribute("messages", new ReactiveDataDriverContextVariable(Flux.just(messages)));
        return "index";
    }
}
