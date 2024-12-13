package be.kdg.programming3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Controller
public class PredictionController {

    @GetMapping("/prediction")
    public String getPredictions(Model model) {
        try {
            // Run the Python script
            ProcessBuilder pb = new ProcessBuilder("predictor/venv/Scripts/python.exe", "predictor/ModelforCareBot/prediction.py");
            Process process = pb.start();

            // Capture standard output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String predictions = reader.lines().collect(Collectors.joining("\n"));
            reader.close();

            // Log standard output to console
            System.out.println("Predictions Output: ");
            System.out.println(predictions);

            // Capture error stream
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String errors = errorReader.lines().collect(Collectors.joining("\n"));
            System.err.println("Errors: ");
            System.err.println(errors);

            errorReader.close();

            // Wait for the process to complete
            process.waitFor();

            // Pass the predictions to Thymeleaf
            model.addAttribute("prediction", predictions);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("predictions", "Error fetching predictions.");
        }

        return "prediction";
    }
}