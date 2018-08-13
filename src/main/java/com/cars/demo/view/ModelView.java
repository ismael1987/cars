package com.cars.demo.view;

import com.cars.demo.model.Brand;
import com.cars.demo.model.Modell;
import com.cars.demo.repository.BrandRepository;
import com.cars.demo.repository.ModelRepository;
import com.cars.demo.service.RepositoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class ModelView {

    @Autowired
    ModelRepository modelRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    RepositoryServices repositoryServices;



    @GetMapping("/model")
    public String getmodel(Model model){
        List<Brand> brands =brandRepository.findAll().stream().collect(Collectors.toList());
        model.addAttribute("brands",brands);
        return "/model";
    }

    @PostMapping("/model")
    public String addmodel(@Valid String modelNumber, HttpServletRequest request){

        Long brand =Long.parseLong(request.getParameter("brand"));
        Optional<Brand> brandfind= brandRepository.findAll().stream().filter(bf -> bf.getId().equals(brand)).findFirst();
        if(brandfind.isPresent()){
            Modell modell=new Modell();
            modell.setModelNumber(modelNumber);
            modell.setBrand(brandfind.get());
            modelRepository.save(modell);
        }
        return "redirect:model";
    }
}
