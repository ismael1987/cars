package com.cars.demo.view;

import com.cars.demo.model.User;
import com.cars.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class Register {

    @Autowired
    private UserRepository userRepository;



    @GetMapping("/register")
    public String registerUser(){

        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@Valid String login, String firstName,String lastName,String email,String password){

        User newUser = new User();
        userRepository.save(newUser);

       return "index";
    }

}
