package com.cars.demo.view;

import com.cars.demo.model.User;
import com.cars.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

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
        newUser.setLogin(login);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setPassword(password);
        Set<String> authorities= new HashSet<>();
        authorities.add("user");
        newUser.setAuthorities(authorities);
        userRepository.save(newUser);

       return "index";
    }

}
