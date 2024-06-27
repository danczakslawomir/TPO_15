package pl.edu.pja.sladan.tpo_15.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControler {

    @GetMapping("/login")
    String loginForm(){
        return "login-form";
    }

}
