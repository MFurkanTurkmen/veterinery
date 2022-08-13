package com.furkan.petclinic.controllermodel;

import com.furkan.petclinic.dto.request.CreateOwnerRequest;
import com.furkan.petclinic.repository.entity.Owner;
import com.furkan.petclinic.service.OwnerService;
import com.furkan.petclinic.service.impl.OwnerServiceImpl;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("")

public class LoginController {
    @Autowired
    OwnerService ownerService;

    ModelMapper mapper;
    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView model= new ModelAndView();
        model.setViewName("login");
        return model;
    }

    @PostMapping("/login")
    public Object doLogin(String email, String password){
        ModelAndView model=new ModelAndView();
        Optional<Owner> owner=ownerService.findByOwnerEmailandOwnerPassword(email,password);
        if (owner.isPresent()){
            model.setViewName("home");
            model.addObject("owner",owner.get());
            return model;
        }
        else {
            System.out.println("hata");
            return "register";
        }
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
        model.setViewName("/index");
        return model;
    }

    @PostMapping("/register")
    public ModelAndView doRegister(Owner owner, String name
            , String surname, String email, String password,
                                    String address, String phone){
        ModelAndView model= new ModelAndView();
        CreateOwnerRequest createOwnerRequest= new CreateOwnerRequest();
        createOwnerRequest.setOwnerName(name);
        createOwnerRequest.setOwnerSurname(surname);
        createOwnerRequest.setOwnerEmail(email);
        createOwnerRequest.setOwnerPassword(password);
        createOwnerRequest.setOwnerAddress(address);
        createOwnerRequest.setOwnerPhone(phone);
        ownerService.createOwner(createOwnerRequest);
        model.setViewName("/");
        return model;
    }





}


