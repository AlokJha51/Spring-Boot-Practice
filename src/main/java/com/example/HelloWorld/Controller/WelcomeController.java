package com.example.HelloWorld.Controller;

import com.example.HelloWorld.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class WelcomeController {

   /* @Autowired
    LoginService service;*/

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String displayWelcomePage(ModelMap model) {
        model.put("name", "alok");
        return "welcome";
    }

   /* @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLogin(ModelMap model, @RequestParam String name,
                              @RequestParam String password) {

        boolean isValidUser  = service.validateUser(name, password);
        if(!isValidUser){
            model.put("errorMessage","Invalid Credentials");
            return "login";
        }
        model.put("name", name);
        model.put("password", password);
        return "welcome";
    }*/

}
