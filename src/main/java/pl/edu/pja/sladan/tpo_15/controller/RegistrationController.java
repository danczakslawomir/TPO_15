package pl.edu.pja.sladan.tpo_15.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.pja.sladan.tpo_15.auth.UserRegisterDTO;
import pl.edu.pja.sladan.tpo_15.auth.UserService;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new UserRegisterDTO());
        return "registration-form";
    }

    @PostMapping("/register")
    public String register(UserRegisterDTO user){
        userService.register(user);
        return "redirect:/confirm";
    }

    @GetMapping("/confirm")
    public String confirm(){
        return "registration-confirm";
    }

}
