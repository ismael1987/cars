package com.cars.demo.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserView {

    @PostMapping("login")
    public String logUser(){
        return "index";
    }


    @GetMapping("/login")
    public String loginUser(){
        return "login";
    }



}
