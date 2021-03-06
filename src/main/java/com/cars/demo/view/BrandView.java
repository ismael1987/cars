package com.cars.demo.view;

import com.cars.demo.model.Brand;
import com.cars.demo.repository.BrandRepository;
import com.cars.demo.service.RepositoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BrandView {
    @Autowired
    BrandRepository brandRepository;

    @Autowired
    private RepositoryServices repositoryServices;

    @ModelAttribute("brands")
    public List<Brand> getbrands(){
        List<Brand> collectBrand = repositoryServices.getAllbrand();
        return collectBrand;
    }

    @GetMapping("/brand")
    public String getbrand(){
        //List<Brand> collectBrand = brandRepository.findAll().stream().collect(Collectors.toList());
        //model.addAttribute("brands",collectBrand);
      return "brand";
    }

    @PostMapping("/brand")
    public String addbrand(@Valid String brand){
        long count = brandRepository.findAll().stream().filter(e -> e.getBrandName().equalsIgnoreCase(brand)).count();

        if(count == 0L){
            Brand newbrand= new Brand(brand);
            brandRepository.save(newbrand);
        }
        return "redirect:brand" ;
    }
}
