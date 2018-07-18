package com.cars.demo.view;

import com.cars.demo.model.Car;
import com.cars.demo.repository.CarRepository;
import com.cars.demo.repository.ColorRepository;
import com.cars.demo.repository.FuelRepository;
import com.cars.demo.repository.GearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class CarView {
    @Autowired
    CarRepository carRepository;
    @Autowired
    ColorRepository colorRepository;
    @Autowired
    GearRepository gearRepository;
    @Autowired
    FuelRepository fuelRepository;

    @GetMapping("/car")
    public String getCar(Model model){
        List<Car> allcars =carRepository.findAll().stream().collect(Collectors.toList());
        model.addAttribute("cars",allcars);
        return "/car";
    }



}
