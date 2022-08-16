package com.furkan.petclinic.controllermodel;

import com.furkan.petclinic.dto.request.CreatePetRequest;
import com.furkan.petclinic.repository.entity.Owner;
import com.furkan.petclinic.service.OwnerService;
import com.furkan.petclinic.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/owner")
public class OwnersController {

    @Autowired
    PetService petService;
    @Autowired
    OwnerService ownerService;

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView model= new ModelAndView();
        model.setViewName("owner/index");
        return model;
    }

    @PostMapping("/index")
    public String doLogin(String email, String password){
        ModelAndView model=new ModelAndView();
        Optional<Owner> owner=ownerService.findByOwnerEmailandOwnerPassword(email,password);
        if (owner.isPresent()){
            model.setViewName("owner/index");
            model.addObject("owner",owner.get());
            return "redirect:/owner/index" ;
        }
        else {
            return "redirect:/login";
        }
    }



    @GetMapping("/pet")
    public ModelAndView pet(){
        ModelAndView model=new ModelAndView();
        model.addObject("pettable", petService.findall());
        model.setViewName("owner/pet");
        return model;
    }

    @PostMapping("/petsave")
    public String petSave( String name
            , String type, String family, long age){
        CreatePetRequest createPetRequest =new CreatePetRequest();
        createPetRequest.setPetName(name);
        createPetRequest.setPetType(type);
        createPetRequest.setPetFamily(family);
        createPetRequest.setPetAge(age);
        petService.createPet(createPetRequest);
        return "redirect:/owner/pet";
    }

    @GetMapping("/owner")
    public ModelAndView owner(){
        ModelAndView model=new ModelAndView();
        model.addObject("ownertable", ownerService.findall());
        model.setViewName("owner/owner");
        return model;
    }

    @GetMapping("/petsinfo")
    public ModelAndView petsinfo(){
        ModelAndView model=new ModelAndView();
        model.setViewName("owner/petsinfo");
        return model;
    }

    @GetMapping("/contact")
    public ModelAndView contact(){
        ModelAndView model= new ModelAndView();
        model.setViewName("owner/contact");
        return model;
    }

}
