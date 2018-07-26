/**************************************************
 *               Cars System
 *
 *
 * code written by: Mohamed Dahman &  Ismael Alhussein Alali
 *
 * This program for buy and sell Cars  .
 *
 ***************************************************/

package com.cars.demo.view;

import com.cars.demo.model.Color;
import com.cars.demo.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ColorView {

    @Autowired
    ColorRepository colorRepository;

    @ModelAttribute("colors")
    public List<Color> getcolors(){
        List<Color> collectColor = colorRepository.findAll().stream().collect(Collectors.toList());
        return collectColor;
    }


    @GetMapping("/color")
    public String getcolor(){

        return  "color";
    }


    @PostMapping("/color")
    String addColor(@Valid  String color){
        Color newcolor = new Color(color);
        colorRepository.save(newcolor);
        return "index";
    }


}
