package be.kdg.programming3.controller;

import be.kdg.programming3.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    @GetMapping("/registration")
    public String showRegistrationPage(Model model) {
        model.addAttribute("employee", new Employee());
        return "signup";
    }

    @PostMapping("/register/save")
    public String saveRegistration(@ModelAttribute("user") Employee employee) {
        // Add logic to save user to the database
        return "redirect:/login?success"; // Redirect to login page after successful registration
    }
}
