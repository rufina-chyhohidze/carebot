package be.kdg.programming3.controller;

import be.kdg.programming3.domain.Employee;
import be.kdg.programming3.domain.EmployeeRole;
import be.kdg.programming3.domain.Gender;
import be.kdg.programming3.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        return "log-in";
    }
    @PostMapping("/login")
    public String logInToUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        LOG.debug("Received login request for employee with email: {}",email);

        if (employeeLoginDetailsCorrect(email, password)) {
            LOG.debug("Login successful for employee with email: {}", email);

            Employee employeeLoggedIn = this.employeeService.getEmployeeByEmail(email);

            Employee checkingExistingEmployeeInSession = (Employee) session.getAttribute("userLoggedIn");
            if (checkingExistingEmployeeInSession != null) {
                LOG.warn("User already logged in, please log out to change users");
                return "redirect:/login";
            } else {
                LOG.debug("Adding user to session since no user is currently logged in");
                session.setAttribute("userLoggedIn", employeeLoggedIn);
            }

            model.addAttribute("employee", employeeLoggedIn);
            return "redirect:/item-request";
        }

        LOG.debug("Login unsuccessful for employee with email: {} - Please create an account.", email);
        return "redirect:/signup";
    }

    private boolean employeeLoginDetailsCorrect(String email, String password) {
        return this.employeeService.checkIfEmployeeEmailExists(email) && this.employeeService.checkCorrectPasswordForEmployeeWithEmail(email, password);
    }

    @GetMapping("/logOut")
    public String logOut(HttpSession session) {
        Employee checkingExistingEmployeeInSession = (Employee) session.getAttribute("userLoggedIn");
        if (checkingExistingEmployeeInSession != null) {
            LOG.warn("Logging out");
            session.invalidate();  // closes the session for the user


        } else {
            LOG.debug("No user logged in so cannot log out");
        }

        return "redirect:/";
    }

    @GetMapping("/signup")
    public String showSignupPage() {
        return "sign-up";
    }

    @PostMapping("/signup")
    public String createEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("gender") String gender,
                                 @RequestParam("employeeType") String employeeType,
                                 @RequestParam("phoneNumber") String phoneNumber,
                                 @RequestParam("email") String email,
                                 @RequestParam("password") String password,
                                 @RequestParam("date") String date) {
        LOG.debug("Requested a sign up with values: {}, {}, {}, {}, {}, {}, {}", firstName, lastName, gender, employeeType, phoneNumber, email, password);
        // Create the employee object
        Employee newEmployee = new Employee(firstName, lastName, Gender.valueOf(gender), EmployeeRole.valueOf(employeeType), phoneNumber, email, password);

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date newDate = formatter.parse(date);
            newEmployee.setDateOfBirth(newDate);
        } catch (Exception e) {
            LOG.error("Couldn't set birth date for employee, cast exception: " + e.getMessage());
        }

        Employee employee = null;
        try {
            employee = employeeService.createEmployee(newEmployee);
            System.out.println("Created new employee now has id: " + employee);
        } catch (Exception e)
        {
            LOG.debug("Couldn't create employee: ", e.getMessage());
        }

        if (employee == null) return "redirect:/signup";

        // Redirect to the login page after successful registration
        return "redirect:/login";
    }
}
