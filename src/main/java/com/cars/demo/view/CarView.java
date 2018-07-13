package com.cars.demo.view;

import com.cars.demo.model.Color;
import com.cars.demo.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CarView {

    @Autowired
    ColorRepository colorRepository;

    @GetMapping("/color")
    public List<String> getcolor(){
        Color color = new Color();
        return colorRepository.findAll().stream().map(e->e.getDescription()).collect(Collectors.toList());
    }
}
