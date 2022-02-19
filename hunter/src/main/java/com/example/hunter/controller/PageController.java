package com.example.hunter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(){
        return "index.html";
    }

    @RequestMapping("/header")
    public  String header(){
        return "header.html";
    }
}
