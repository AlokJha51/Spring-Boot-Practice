package com.example.HelloWorld.Controller;

import com.example.HelloWorld.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String displayLogin(ModelMap model) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
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
    }

}
