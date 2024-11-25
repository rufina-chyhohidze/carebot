package be.kdg.programming3.controller;

import be.kdg.programming3.domain.Employee;
import be.kdg.programming3.domain.EmployeeRole;
import be.kdg.programming3.domain.Gender;
import be.kdg.programming3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final EmployeeService employeeService;

    @Autowired
    public LoginController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String createEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("gender") String gender,
                                 @RequestParam("employeeType") String employeeType,
                                 @RequestParam("phoneNumber") String phoneNumber,
                                 @RequestParam("email") String email,
                                 @RequestParam("password") String password) {

        // Create the employee object
        Employee newEmployee = new Employee(firstName, lastName, Gender.valueOf(gender), EmployeeRole.valueOf(employeeType), phoneNumber, email, password);

        // Save the employee to the database
        employeeService.saveEmployee(newEmployee);

        System.out.println("Created new employee: " + newEmployee);

        // Redirect to the login page after successful registration
        return "redirect:/login";
    }
}
