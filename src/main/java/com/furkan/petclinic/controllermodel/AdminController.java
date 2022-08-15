package com.furkan.petclinic.controllermodel;

import com.furkan.petclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    OwnerService ownerService;
    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView model= new ModelAndView();
        model.setViewName("admin/index");
        return model;
    }

}
