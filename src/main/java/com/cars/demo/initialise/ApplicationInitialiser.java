package com.cars.demo.initialise;

import com.cars.demo.model.Color;
import com.cars.demo.model.Gear;
import com.cars.demo.repository.ColorRepository;
import com.cars.demo.repository.GearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.stream.Collectors;

@Configuration
public class ApplicationInitialiser {


    @Bean
    ApplicationRunner  intialiseData(ColorRepository colorRepository, GearRepository gearRepository){
        return  args -> {
          //  colorRepository.deleteAll();
           // String theColors = "Black,Whait,Red";

            //Arrays.stream(theColors.split(",")).collect(Collectors.toList()).stream().map(e-> new Color(e)).forEach(color->colorRepository.save(color));

            colorRepository.findAll().stream().forEach(color -> color.toString());

            gearRepository.deleteAll();
            String theyGearType ="Manual ,Automatic ,Semi automatic ";

            Arrays.stream(theyGearType.split(",")).collect(Collectors.toList()).stream().map(e-> new Gear(e)).forEach(gear -> gearRepository.save(gear));

            gearRepository.findAll().stream().forEach(gear -> gear.toString());

        };


    }


}
