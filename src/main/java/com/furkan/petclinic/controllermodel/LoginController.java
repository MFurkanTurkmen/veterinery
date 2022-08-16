package com.furkan.petclinic.controllermodel;

import com.furkan.petclinic.dto.request.CreateOwnerRequest;
import com.furkan.petclinic.repository.entity.Owner;
import com.furkan.petclinic.service.OwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        model.setViewName("register");
        return login();
    }





}


