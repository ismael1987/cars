package com.cars.demo.view;

import com.cars.demo.model.*;
import com.cars.demo.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Controller
public class CarView {


    private final Logger log = LoggerFactory.getLogger(general.class);


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
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    StateRepository stateRepository;


    @GetMapping("/addCar")
    public String buyCar(Model model){
        log.info(model.toString());
        List<Color> collectColor = colorRepository.findAll().stream().collect(Collectors.toList());
        model.addAttribute("colors",collectColor);

        List<Gear> gearList = gearRepository.findAll().stream().collect(Collectors.toList());
        model.addAttribute("gears",gearList);

        List<Modell> modelList = modelRepository.findAll().stream().collect(Collectors.toList());
        model.addAttribute("models",modelList);

        List<Brand> brandList = brandRepository.findAll().stream().collect(Collectors.toList());
        model.addAttribute("brands",brandList);

        List<Fuel> fuelList = fuelRepository.findAll().stream().collect(Collectors.toList());
        model.addAttribute("fuels",fuelList);

        List<Country> countryList = countryRepository.findAll().stream().collect(Collectors.toList());
        model.addAttribute("countries",countryList);

        List<State> stateList = stateRepository.findAll().stream().collect(Collectors.toList());
        model.addAttribute("states",stateList);

        return "addCar";
    }


    @PostMapping("/addCar")
    public String addCar(HttpServletRequest request){

        //, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes
        log.info("Add New Car");

        Car car = new Car();

        Long brandNo = Long.parseLong(request.getParameter("brand"));
        Optional<Brand> exsitBrand = brandRepository.findAll().stream().filter(brand -> brand.getId().equals(brandNo)).findFirst();

        Long modelNo = Long.parseLong(request.getParameter("model"));
        Optional<Modell> existmodel = modelRepository.findAll().stream().filter(model -> model.getId().equals(modelNo)).findFirst();

        Long countrylNo = Long.parseLong(request.getParameter("country"));
        Optional<Country> existcountry = countryRepository.findAll().stream().filter(country -> country.getId().equals(countrylNo)).findFirst();

        Long stateNo = Long.parseLong(request.getParameter("state"));
        Optional<State> existstate = stateRepository.findAll().stream().filter(state -> state.getId().equals(stateNo)).findFirst();

        Long fuelNo = Long.parseLong(request.getParameter("fuel"));
        Optional<Fuel> existfuel = fuelRepository.findAll().stream().filter(fuel -> fuel.getId().equals(fuelNo)).findFirst();


        Long gearNo = Long.parseLong(request.getParameter("gear"));
        Optional<Gear> existGear = gearRepository.findAll().stream().filter(gear -> gear.getId().equals(gearNo)).findFirst();

        Long colorNo = Long.parseLong(request.getParameter("color"));
        Optional<Color> first = colorRepository.findAll().stream().filter(color -> color.getId().equals(colorNo)).findFirst();
        if (first.isPresent() && existmodel.isPresent() && exsitBrand.isPresent() && existcountry.isPresent() && existstate.isPresent() && existfuel.isPresent()){
            car.setColor(first.get());
            car.setBrand(exsitBrand.get());
            car.setModell(existmodel.get());
            car.setGear(existGear.get());
            car.setCountry(existcountry.get());
            car.setState(existstate.get());
            car.setFuel(existfuel.get());
            Long mileage = Long.parseLong(request.getParameter("mileage"));

            String dateOfRegistration = request.getParameter("dateOfRegistration");
            car.setMileage(mileage);

      /*      try {
                byte[] bytes = file.getBytes();
                car.setImage(bytes);
                //carRepository.save(car);
                redirectAttributes.addFlashAttribute("flash.message", "Successfully uploaded");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("flash.message", "Failed to upload");
                return "You failed to upload because " + " => " + e.getMessage();
            }

    */        carRepository.save(car);

        }
        return "index";
    }

}
