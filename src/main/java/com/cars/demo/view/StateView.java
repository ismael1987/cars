package com.cars.demo.view;

import com.cars.demo.model.Color;
import com.cars.demo.model.Country;
import com.cars.demo.model.State;
import com.cars.demo.repository.CountryRepository;
import com.cars.demo.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class StateView {

    @Autowired
    StateRepository stateRepository;

    @Autowired
    CountryRepository countryRepository;



    @GetMapping("/state")
    public String getState(Model model){
        List<Country> countries = countryRepository.findAll().stream().collect(Collectors.toList());
        model.addAttribute("countries",countries);
        return "state";
    }


    @PostMapping("/state")
    public String postState(@Valid String stateName , HttpServletRequest request){


        Long country = Long.parseLong(request.getParameter("country"));


        Optional<Country> countryFind = countryRepository.findAll().stream().filter(cn -> cn.getId().equals(country)).findFirst();

        if (countryFind.isPresent()){
            State state = new State();
            state.setStateName(stateName);
            state.setCountry(countryFind.get());
            stateRepository.save(state);
        }

        return "redirect:state";
    }


}
