package be.kdg.programming3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "index"; // Maps to index.html
    }

    //I COMMENTED IT BECAUSE IT WAS A MAPPING CONFLICT

    //@GetMapping("/requestform")
    //public String requestForm() {
    //  return "request-form"; // Maps to requestform.html
    // }

    @GetMapping("/sendrobot")
    public String sendRobot() {
        return "send-robot"; // Maps to sendrobot.html
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Maps to warehouse.html
    }

    @GetMapping("/warehouse")
    public String warehouse() {
        return "warehouse";
    }
    @GetMapping("/register")
    public String register() {
        return "register";
    }
}