package com.furkan.petclinic.controllermodel;

import com.furkan.petclinic.repository.entity.Owner;
import com.furkan.petclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")

public class LoginController {
    OwnerService ownerService;


    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView model= new ModelAndView();
        model.setViewName("login");
        return model;
    }

    @GetMapping("/register")
    public ModelAndView register(){
        ModelAndView model = new ModelAndView();
        model.setViewName("register");
        return model;
    }

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView model= new ModelAndView();
        model.setViewName("index");
        return model;
    }
  /*  @PostMapping("/register")
    public String register(String username,String email,
                           String password,String questions,String answer){
        ownerService.createOwner(

                Ow
        return "redirect:/login";
    }*/

}
