package com.furkan.petclinic.controllermodel;

import com.furkan.petclinic.service.OwnerService;
import com.furkan.petclinic.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@RequestMapping("/admin")
@Controller
public class PetsController {

    @Autowired
    PetService petService;
    @GetMapping("/petpage")
    public ModelAndView owner(){
        ModelAndView model= new ModelAndView();
        model.addObject("pettable", petService.findall() );
        model.setViewName("admin/petpage");
        return model;
    }
    @PostMapping("/deletepet")
    public String deletepet(long id){
        petService.deletePett(id);
        return "admin/petpage";
    }
}
