package com.kodeveloper.food.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    private String name = "ゲスト"; // TODO sessionが使えないためとりあえず


    @RequestMapping(value = "/completeProcess")
    @ResponseBody
    public String completeProcess(
            @RequestParam String name,
            @RequestParam String accessToken,
            @RequestParam String expiresIn,
            @RequestParam String signedRequest,
            @RequestParam String userID
    ) {
        this.name = name;
        System.out.printf(
                "name=%s%naccessToken=%s%nexpiresIn=%s%nsignedRequest=%s%nuserID=%s%n", name, accessToken, expiresIn, signedRequest,userID);
        return "{}";
    }

    @RequestMapping("/complete")
    public String complete(Model model) {
        model.addAttribute("name", this.name);
        return "login-complete";
    }
}
