package com.example.jmusicDemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping(value = "/")
    public String home(Model model){
        model.addAttribute("greeting", "Wazzup");
        return "home";
    }



}
