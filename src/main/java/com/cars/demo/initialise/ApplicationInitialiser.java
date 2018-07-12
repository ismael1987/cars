package com.cars.demo.initialise;

import com.cars.demo.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationInitialiser {

    @Autowired
    ColorRepository colorRepository;

    ApplicationRunner  intialiseData(){
        return  args -> {
            colorRepository.deleteAll();
            String theColors = "Black,Whait,Red";


        };
    }

}
