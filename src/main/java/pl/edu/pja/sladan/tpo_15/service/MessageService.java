package pl.edu.pja.sladan.tpo_15.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public String getMessage(){
        return "Hello " + SecurityContextHolder.getContext().getAuthentication().getName() + "!";
    }
}
