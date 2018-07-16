package com.cars.demo.view;

import com.cars.demo.model.Country;
import com.cars.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CountryView {
    @Autowired
    CountryRepository countryRepository;

    @GetMapping("/country")
    public String getcountry(Model model){
        List<Country> collectCountry = countryRepository.findAll().stream().collect(Collectors.toList());
        model.addAttribute("countries",collectCountry);
        return "country";
    }

    @PostMapping("/country")
    public String addcountry(@Valid String country){

        Country newcountry = new Country(country);
        countryRepository.save(newcountry);
        return "index";
    }
}
