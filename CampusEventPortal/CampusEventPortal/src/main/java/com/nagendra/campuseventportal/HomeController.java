package com.nagendra.campuseventportal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/technical")
    public String technicalEvents() {
        return "technical-events";
    }

    @GetMapping("/cultural")
    public String culturalEvents() {
        return "cultural-events";
    }

    @GetMapping("/sports")
    public String sportsEvents() {
        return "sports-events";
    }

    @GetMapping("/annual")
    public String annualFest() {
        return "annual-fest";
    }

}