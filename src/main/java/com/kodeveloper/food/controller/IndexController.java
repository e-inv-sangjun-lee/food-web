package com.kodeveloper.food.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@Slf4j
public class IndexController {

    private Facebook facebook;
    private ConnectionRepository connectionRepository;

    public IndexController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @GetMapping("/")
    public String helloFacebook(Model model) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "index";
        }

        {
//        model.addAttribute("facebookProfile", facebook.userOperations().getUserProfile());
            //TODO https://stackoverflow.com/questions/39890885/error-message-is-12-bio-field-is-deprecated-for-versions-v2-8-and-higher
            String [] fields = { "id", "email", "name", "first_name", "last_name" };
            model.addAttribute("facebookProfile", facebook.fetchObject("me", User.class, fields));
        }
        PagedList<Post> feed = facebook.feedOperations().getFeed();
        model.addAttribute("feed", feed);
        return "index";
    }
}
