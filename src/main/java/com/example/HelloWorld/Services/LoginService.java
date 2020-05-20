package com.example.HelloWorld.Services;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
    public boolean validateUser(String user, String password) {
        return user.equalsIgnoreCase("alok") && password.equals("dummy");
    }
}



