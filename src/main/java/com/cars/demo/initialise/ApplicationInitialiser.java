package com.cars.demo.initialise;

import com.cars.demo.model.*;
import com.cars.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;



import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class ApplicationInitialiser {

    @Autowired
    StateRepository stateRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Bean
    ApplicationRunner  intialiseData(ColorRepository colorRepository, GearRepository gearRepository, StateRepository stateRepository){
        return  args -> {

            User user = new User();
            user.setFirstName("First");
            user.setLastName("Last");
            user.setLogin("user");
            user.setPassword(passwordEncoder.encode("user"));
            user.setAuthorities(Stream.of("USER").collect(Collectors.toSet()));
            user.setEmail("user@cars.at");
            if (!userRepository.findOneByLogin("user").isPresent())
                    userRepository.save(user);

            User admin = new User();
            admin.setFirstName("First");
            admin.setLastName("Last");
            admin.setLogin("admin");

            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setAuthorities(Stream.of("ADMIN").collect(Collectors.toSet()));
            admin.setEmail("admin@cars.at");
            if (!userRepository.findOneByLogin("admin").isPresent())
                userRepository.save(admin);



          //  colorRepository.deleteAll();
           // String theColors = "Black,Whait,Red";

            //Arrays.stream(theColors.split(",")).collect(Collectors.toList()).stream().map(e-> new Color(e)).forEach(color->colorRepository.save(color));

            colorRepository.findAll().stream().forEach(color -> color.toString());

            gearRepository.deleteAll();
            String theyGearType ="Manual ,Automatic ,Semi automatic ";

            Arrays.stream(theyGearType.split(",")).collect(Collectors.toList()).stream().map(e-> new Gear(e)).forEach(gear -> gearRepository.save(gear));

            gearRepository.findAll().stream().forEach(gear -> gear.toString());


           // stateRepository.deleteAll();
            //String theState = "Burgenland,Kärnten,Niederösterreich,Oberösterreich,Salzburg,Steiermark,Tirol,Vorarlberg,Wien";
            //List<Country> allCountry = countryRepository.findAll();
            //if (allCountry.size() >0 ) {
              //  Country country = allCountry.get(0);
                //Arrays.stream(theState.split(",")).collect(Collectors.toList()).stream().map(e -> new State(e, country)).forEach(state -> stateRepository.save(state));
            //}


        };


    }


}
