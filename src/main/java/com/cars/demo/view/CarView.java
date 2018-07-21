package com.cars.demo.view;

import com.cars.demo.model.Car;
import com.cars.demo.model.Color;
import com.cars.demo.model.Gear;
import com.cars.demo.repository.CarRepository;
import com.cars.demo.repository.ColorRepository;
import com.cars.demo.repository.FuelRepository;
import com.cars.demo.repository.GearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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

    @GetMapping("/addCar")
    public String buyCar(Model model){

        List<Color> collectColor = colorRepository.findAll().stream().collect(Collectors.toList());
        model.addAttribute("colors",collectColor);

        List<Gear> gearList = gearRepository.findAll().stream().collect(Collectors.toList());
        model.addAttribute("gears",gearList);

        return "addCar";
    }


    @PostMapping("/addCar")
    public String addCar(HttpServletRequest request){

        Car car = new Car();

        Long colorNo = Long.parseLong(request.getParameter("color"));
        Optional<Color> first = colorRepository.findAll().stream().filter(color -> color.getId().equals(colorNo)).findFirst();
        if (first.isPresent()){
            car.setColor(first.get());

            Long mileage = Long.parseLong(request.getParameter("mileage"));

            String dateOfRegistration = request.getParameter("dateOfRegistration");
            car.setMileage(mileage);
            carRepository.save(car);


        }







        return "index";
    }

}
