package be.kdg.programming3.controller;

import be.kdg.programming3.domain.Employee;
import be.kdg.programming3.domain.ItemRequest;
import be.kdg.programming3.service.ItemRequestService;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/userLoggedIn")
public class DashboardController {

    private final ItemRequestService itemRequestService;

    public DashboardController(ItemRequestService itemRequestService) {
        this.itemRequestService = itemRequestService;
    }

    @GetMapping("/{userId}")
    public String userDashboard(@PathVariable(value = "userId") int userId, Model model, HttpSession session) {
        Employee employeeLoggedIn = (Employee) session.getAttribute("userLoggedIn");
//        if (employeeLoggedIn == null) return "redirect:/login";

        List<ItemRequest> itemRequestsOfEmployee = this.itemRequestService.getAllItemRequestsOfEmployee(userId);
        model.addAttribute("itemRequests", itemRequestsOfEmployee);

        return "dashboard";
    }

}
