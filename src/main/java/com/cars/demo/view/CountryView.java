package com.cars.demo.view;

import com.cars.demo.model.Country;
import com.cars.demo.repository.CountryRepository;
import com.cars.demo.service.RepositoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CountryView {
    @Autowired
    CountryRepository countryRepository;

    @Autowired
    RepositoryServices repositoryServices;

    @ModelAttribute("countries")
    public List<Country> getCountries(){
        List<Country> collectcountries = repositoryServices.getAllcountry();
        return collectcountries;
    }

    @GetMapping("/country")
    public String getcountry(){
        return "country";
    }

    @PostMapping("/country")
    public String addcountry(@Valid String country){

        long count1 = countryRepository.findAll().stream().filter(e -> e.getCountryName().equalsIgnoreCase(country)).count();
        if(count1 == 0L){
            Country newcountry = new Country(country);
            countryRepository.save(newcountry);
        }
        return "redirect:country";
    }
}
