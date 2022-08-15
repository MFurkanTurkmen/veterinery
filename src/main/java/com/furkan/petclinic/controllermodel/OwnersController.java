package com.furkan.petclinic.controllermodel;

import com.furkan.petclinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class OwnersController {

    @Autowired
    OwnerService ownerservice;
    @GetMapping("/ownerpage")
    public ModelAndView owner(){
        ModelAndView model= new ModelAndView();
        model.addObject("ownertable", ownerservice.findall() );
        model.setViewName("admin/ownerpage");
        return model;
    }



}
