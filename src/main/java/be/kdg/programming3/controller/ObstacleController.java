package be.kdg.programming3.controller;

import be.kdg.programming3.domain.Obstacle;
import be.kdg.programming3.service.ObstacleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ObstacleController {

    private final ObstacleService obstacleService;
    private static final Logger LOG = LoggerFactory.getLogger(ObstacleController.class);

    public ObstacleController(ObstacleService obstacleService) {this.obstacleService = obstacleService;}

    @GetMapping("/obstacles")
    public String showObstacles(Model model) {
        List<Obstacle> obstacles = obstacleService.getAllObstacles();
        model.addAttribute("obstacles", obstacles);
        return "obstacle-list";
    }

    @PostMapping("/addObstacle")
    public String addObstacle(@ModelAttribute Obstacle obstacle) {
        obstacleService.addObstacle(obstacle.getObstacleId());
        return "redirect:/obstacles";
    }

    //add GetMapping for addObstacles
}
