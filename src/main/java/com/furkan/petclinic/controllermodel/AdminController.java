package com.furkan.petclinic.controllermodel;

import com.furkan.petclinic.dto.request.CreatePetRequest;
import com.furkan.petclinic.dto.request.CreateUserRequest;
import com.furkan.petclinic.repository.entity.User;
import com.furkan.petclinic.service.OwnerService;
import com.furkan.petclinic.service.PetService;
import com.furkan.petclinic.service.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;
    @Autowired
    OwnerService ownerService;
    @Autowired
    PetService petService;
    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView model= new ModelAndView();
        model.setViewName("admin/index");
        return model;
    }

    @GetMapping("/adminpage")
    public ModelAndView adminList(){
        ModelAndView model = new ModelAndView();
        model.addObject("admintable", userService.findall());
        model.setViewName("admin/adminpage");
        return model;
    }
    @PostMapping("/adminsave")
    public String  adminSave( String name
            , String surname, String email, String password,
                              String phone){
        CreateUserRequest createUserRequest =new CreateUserRequest();
        createUserRequest.setUserName(name);
        createUserRequest.setUserSurname(surname);
        createUserRequest.setUserEmail(email);
        createUserRequest.setUserPassword(password);
        createUserRequest.setUserPhone(phone);
        userService.createUser(createUserRequest);
        return "redirect:/admin/adminpage";
    }

    @GetMapping("/ownerpage")
    public ModelAndView owner(){
        ModelAndView model= new ModelAndView();
        model.addObject("ownertable", ownerService.findall() );
        model.setViewName("admin/ownerpage");
        return model;
    }


    @GetMapping("/petpage")
    public ModelAndView pet(){
        ModelAndView model= new ModelAndView();
        model.addObject("pettable", petService.findall());
        model.setViewName("admin/petpage");
        return model;
    }
    @PostMapping("/deletepet")
    public String deletePet(long id){
        petService.deletePetts(id);
        return "redirect:petpage";
    }

    @PostMapping("/deleteadmin")
    public String deleteAdmin(long id){
        userService.deleteUserr(id);
        return "redirect:adminpage";
    }

    @PostMapping("/deleteowner")
    public String deleteOwner(long id){
        ownerService.deleteOwnerr(id);
        return "redirect:ownerpage";
    }


}
