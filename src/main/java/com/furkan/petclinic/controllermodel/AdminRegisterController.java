package com.furkan.petclinic.controllermodel;

import com.furkan.petclinic.dto.request.CreateOwnerRequest;
import com.furkan.petclinic.dto.request.CreateUserRequest;
import com.furkan.petclinic.repository.entity.Owner;
import com.furkan.petclinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/admin")
public class AdminRegisterController {
    @Autowired
    UserService userService;

    @GetMapping("/adminpage")
    public ModelAndView userlist(){
    ModelAndView model = new ModelAndView();
    model.addObject("admintable", userService.findall());
    model.setViewName("admin/adminpage");
    return model;
}
    @PostMapping("/adminsave")
    public String  adminsave( String name
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

}
