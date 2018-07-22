package com.cars.demo.view;

import com.cars.demo.model.*;
import com.cars.demo.repository.*;
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
    @Autowired
    ModelRepository modelRepository;
    @Autowired
    BrandRepository brandRepository;

    @GetMapping("/addCar")
    public String buyCar(Model model){

        List<Color> collectColor = colorRepository.findAll().stream().collect(Collectors.toList());
        model.addAttribute("colors",collectColor);

        List<Gear> gearList = gearRepository.findAll().stream().collect(Collectors.toList());
        model.addAttribute("gears",gearList);

        List<Modell> modelList = modelRepository.findAll().stream().collect(Collectors.toList());
        model.addAttribute("models",modelList);

        List<Brand> brandList = brandRepository.findAll().stream().collect(Collectors.toList());
        model.addAttribute("brands",brandList);

        return "addCar";
    }


    @PostMapping("/addCar")
    public String addCar(HttpServletRequest request){

        Car car = new Car();

        Long brandNo = Long.parseLong(request.getParameter("brand"));
        Optional<Brand> exsitBrand = brandRepository.findAll().stream().filter(brand -> brand.getId().equals(brandNo)).findFirst();

        Long modelNo = Long.parseLong(request.getParameter("model"));
        Optional<Modell> existmodel = modelRepository.findAll().stream().filter(model -> model.getId().equals(modelNo)).findFirst();

        Long gearNo = Long.parseLong(request.getParameter("gear"));
        Optional<Gear> existGear = gearRepository.findAll().stream().filter(gear -> gear.getId().equals(gearNo)).findFirst();

        Long colorNo = Long.parseLong(request.getParameter("color"));
        Optional<Color> first = colorRepository.findAll().stream().filter(color -> color.getId().equals(colorNo)).findFirst();
        if (first.isPresent() && existmodel.isPresent() && exsitBrand.isPresent()){
            car.setColor(first.get());
            car.setBrand(exsitBrand.get());
            car.setModell(existmodel.get());
            car.setGear(existGear.get());
            Long mileage = Long.parseLong(request.getParameter("mileage"));

            String dateOfRegistration = request.getParameter("dateOfRegistration");
            car.setMileage(mileage);
            carRepository.save(car);


        }
        return "index";
    }

}
