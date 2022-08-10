package com.furkan.petclinic.controllermodel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

  /*  @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView doLogin(String email ,String password){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;

    }*/

   /* @GetMapping("/register")
    public ModelAndView register(){
        ModelAndView model= new ModelAndView();
        model.setViewName("register");
        return model;
    }*/
   @GetMapping("/register")
   public ModelAndView register(){
       ModelAndView model = new ModelAndView();
       model.setViewName("register");
       return model;
   }
    @PostMapping("/register")
    public ModelAndView register(String name ,String surname, String password
                                 ,String email,String phone,String adress){
        ModelAndView model= new ModelAndView();
        model.setViewName("register");
        return model;
    }



   /* @PostMapping("/register")
    public String register(String username,String email,
                           String password,String questions,String answer){
        userService.save(
                User.builder()
                        .username(username)
                        .password(password)
                        .email(email)
                        .question(questions)
                        .answer(answer)
                        .build()
        );
        return "redirect:/login";
    }*/
}
