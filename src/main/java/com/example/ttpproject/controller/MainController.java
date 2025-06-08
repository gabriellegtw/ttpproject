package com.example.ttpproject.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Controllers are responsible for handling incoming web requests,
// processing it and sending back a response
@Controller
public class MainController {
    // This is a test endpoint

    // RequestMapping tells Spring which URL path it will respond to
    // E.g., if the argument is "/read",it the http path will need to have it at the end
    @RequestMapping("/test")
    public String index() {
        // index.html is the view file
        return "index.html";
    }
}
