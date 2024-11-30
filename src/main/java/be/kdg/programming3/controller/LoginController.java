package be.kdg.programming3.controller;

import be.kdg.programming3.domain.Employee;
import be.kdg.programming3.domain.EmployeeRole;
import be.kdg.programming3.domain.Gender;
import be.kdg.programming3.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    private final EmployeeService employeeService;

    @Autowired
    public LoginController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
    @PostMapping("/login")
    public String logInToUser(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("options") String option, Model model) {
        LOG.debug("Received login request for employee with email: {}",email);

        if (this.employeeService.checkIfEmployeeEmailExists(email) && this.employeeService.checkCorrectPasswordForEmployeeWithEmail(email, password)) {
            LOG.debug("Login successful for employee with email: {}", email);
            Employee employeeLoggedIn = this.employeeService.getEmployeeByEmail(email);
            if (option.equalsIgnoreCase("warehouse")) {
                model.addAttribute("employee", employeeLoggedIn);
                return "redirect:/warehouse";
            }
            else {
                model.addAttribute("employee", employeeLoggedIn);
                return "redirect:/item-request";
            }
        }

        LOG.debug("Login unsuccessful for employee with email: {} - Please create an account.", email);
        return "redirect:/signup";
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
        System.err.println("\n\n EMployee without id cause not saved: " + newEmployee);
        Employee employee = employeeService.createEmployee(newEmployee);

        System.out.println("Created new employee now has id: " + employee);

        // Redirect to the login page after successful registration
        return "redirect:/login";
    }
}
