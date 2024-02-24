package com.coderscampus.benwoodardassignment14.benwoodardassignment14.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChannelController {
    @GetMapping("")
    public String getWelcomePage() {
        return "welcome";
    }
}
