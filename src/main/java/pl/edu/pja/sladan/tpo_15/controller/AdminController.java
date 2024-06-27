package pl.edu.pja.sladan.tpo_15.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.pja.sladan.tpo_15.auth.UserService;

@Controller
@RequestMapping("/adminPage")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("userEmails", userService.findAllUserEmails());
        return "admin";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam String email) {
        userService.deleteUser(email);
        return "redirect:/adminPage";
    }

}
