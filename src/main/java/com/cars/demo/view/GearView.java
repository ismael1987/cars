package com.cars.demo.view;

import com.cars.demo.model.Gear;
import com.cars.demo.repository.GearRepository;
import com.cars.demo.service.RepositoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class GearView {

    @Autowired
    GearRepository gearRepository;

    @Autowired
    RepositoryServices repositoryServices;

    @ModelAttribute("gears")
    public List<Gear> getGears(){
        List<Gear> collectGears = repositoryServices.getAllgear();
        return collectGears;
    }

    @GetMapping("/gear")
    public String getgear(){
       // List<Gear> CollectGear = gearRepository.findAll().stream().collect(Collectors.toList());
        //model.addAttribute("gears",CollectGear);
        return "gear";
    }

    @PostMapping("gear")
    public String addgear(@Valid String gear){
        Gear newgear = new Gear(gear);
        gearRepository.save(newgear);
        return "index";
    }
}
