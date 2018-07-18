package com.cars.demo.initialise;

import com.cars.demo.model.Color;
import com.cars.demo.model.Country;
import com.cars.demo.model.Gear;
import com.cars.demo.model.State;
import com.cars.demo.repository.ColorRepository;
import com.cars.demo.repository.CountryRepository;
import com.cars.demo.repository.GearRepository;
import com.cars.demo.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Configuration
public class ApplicationInitialiser {

    @Autowired
    StateRepository stateRepository;

    @Autowired
    CountryRepository countryRepository;

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


            stateRepository.deleteAll();
            String theState = "Burgenland,Kärnten,Niederösterreich,Oberösterreich,Salzburg,Steiermark,Tirol,Vorarlberg,Wien";
            List<Country> allCountry = countryRepository.findAll();
            if (allCountry.size() >0 ) {
                Country country = allCountry.get(0);
                Arrays.stream(theState.split(",")).collect(Collectors.toList()).stream().map(e -> new State(e, country)).forEach(state -> stateRepository.save(state));
            }


        };


    }


}
