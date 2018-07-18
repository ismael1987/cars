package com.cars.demo.view;

import com.cars.demo.model.Brand;
import com.cars.demo.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BrandView {
    @Autowired
    BrandRepository brandRepository;

    @GetMapping("/brand")
    public String getbrand(Model model){
        List<Brand> collectBrand = brandRepository.findAll().stream().collect(Collectors.toList());
        model.addAttribute("brands",collectBrand);
      return "brand";
    }

    @PostMapping("/brand")
    public String addbrand(@Valid String brand){
        Brand newbrand= new Brand(brand);
        brandRepository.save(newbrand);
        return "index" ;
    }
}