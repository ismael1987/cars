package com.cars.demo.view;

import com.cars.demo.model.Fuel;
import com.cars.demo.repository.FuelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FuelView {
    @Autowired
    FuelRepository fuelRepository;

    @GetMapping("/fuel" )
    public String getfuel(Model model){
        List<Fuel> collectfuel = fuelRepository.findAll().stream().collect(Collectors.toList());
        model.addAttribute("fuels",collectfuel);
        return "fuel";
    }

    @PostMapping("/fuel")
    public String addfuel(@Valid String fuel){
     Fuel newfuel = new Fuel(fuel);
     fuelRepository.save(newfuel);
        return "index";

    }
}
