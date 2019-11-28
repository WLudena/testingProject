package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OptionsController {

    @GetMapping("/")
    public String main(){
        return "optionsPage";
    }
    @GetMapping("/options")
    public String options(){
        return "createCourse";
    }
}
