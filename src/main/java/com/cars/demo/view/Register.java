package com.cars.demo.view;

import com.cars.demo.model.User;
import com.cars.demo.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;

@Controller
public class Register {

    private final Logger log = LoggerFactory.getLogger(Register.class);

    @Autowired
    private UserRepository userRepository;



    @GetMapping("/register")
    public String registerUser(){

        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@Valid String login, String firstName,String lastName,String email,String password,String passwordConfirm ){
        log.info("Register New User: {}",firstName);
        if ((!passwordConfirm.equals(password))){
            return "redirect:error";
        }
        long existLogin = userRepository.findAll().stream().filter(e -> e.getLogin().equalsIgnoreCase(login)).count();
        long existEmail = userRepository.findAll().stream().filter(e -> e.getEmail().equalsIgnoreCase(email)).count();
        if( existLogin == 0L || existEmail == 0L ){
            User newUser = new User();
            newUser.setLogin(login);
            newUser.setFirstName(firstName);
            newUser.setLastName(lastName);
            newUser.setEmail(email);
            newUser.setPassword(new BCryptPasswordEncoder().encode(password));

            Set<String> authorities= new HashSet<>();
            authorities.add("user");
            newUser.setAuthorities(authorities);
            userRepository.save(newUser);
        }
        else
        {
                  return "redirect:error";
        }
            return "redirect:register";
    }

}
