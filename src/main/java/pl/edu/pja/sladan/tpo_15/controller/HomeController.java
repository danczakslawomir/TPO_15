package pl.edu.pja.sladan.tpo_15.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.pja.sladan.tpo_15.service.MessageService;

@Controller
public class HomeController {

    private final MessageService messageService;

    public HomeController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("message", messageService.getMessage());
        return "index";
    }

    @GetMapping("/userPage")
    public String userPage(){
        return "user";
    }

}
