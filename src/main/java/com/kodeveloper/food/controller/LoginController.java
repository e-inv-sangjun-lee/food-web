package com.kodeveloper.food.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @GetMapping(value = "/completeProcess")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void completeProcess(
            @RequestParam String accessToken,
            @RequestParam String expiresIn,
            @RequestParam String signedRequest,
            @RequestParam String userID
    ) {
        System.out.printf("%s%n%s%n%s%n%s%n", accessToken, expiresIn, signedRequest,userID);
    }

    @RequestMapping("/complete")
    public String complete() {
        return "login-complete";
    }
}
