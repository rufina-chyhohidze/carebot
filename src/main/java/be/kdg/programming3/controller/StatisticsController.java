package be.kdg.programming3.controller;

import be.kdg.programming3.domain.Delivery;
import be.kdg.programming3.domain.ItemRequest;
import be.kdg.programming3.service.DeliveryService;
import be.kdg.programming3.service.ItemRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
    private final ItemRequestService itemRequestService;
    private final DeliveryService deliveryService;

    public StatisticsController(ItemRequestService itemRequestService, DeliveryService deliveryService) {
        this.itemRequestService = itemRequestService;
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public String showStatistics(Model model) {
        List<String> predictions = new ArrayList<>();
        try {
            String pythonScript = "predictor/new_model/new_prediction.py"; //place of the python script
            ProcessBuilder processBuilder = new ProcessBuilder("venv/Scripts/python.exe", pythonScript); //place of the python.exe in the project
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String output = reader.lines().collect(Collectors.joining("\n"));
            reader.close();

            predictions = Arrays.asList(output.split("\n"));
            process.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
            predictions.add("Error fetching predictions.");
        }

        model.addAttribute("predictions", predictions);

        return "statistics";
    }

    @GetMapping("/graph/1")
    @ResponseBody
    public Map<String, Long> getMostFrequentPath() {
        List<ItemRequest> itemRequests = itemRequestService.getAllItemRequests();
        return itemRequests.stream()
                .collect(Collectors.groupingBy(itemRequest -> itemRequest.getPath().toString(),
                        Collectors.counting()));
    }

    @GetMapping("/graph/2")
    @ResponseBody
    public Map<String, Long> getTimeTakenPerDelivery() {
        List<Delivery> deliveries = deliveryService.getAllDeliveries();

        return deliveries.stream()
                .map(delivery -> {
                    double timeTaken = 0.0;
                    if (delivery.getTotalDeliveryTime() != null) {
                        timeTaken = delivery.getTotalDeliveryTime();
                    } else if (delivery.getDeliveryFinished() != null && delivery.getDeliveryStarted() != null) {
                        long timeTakenMillis =
                                java.time.Duration.between(delivery.getDeliveryStarted(), delivery.getDeliveryFinished()).toMillis();
                        timeTaken = timeTakenMillis / (60.0 * 1000.0);
                    }
                    return timeTaken;
                })
                .collect(Collectors.groupingBy(
                        time -> {
                            if (time <= 2) return "0-2 mins";
                            else if (time <= 5) return "2-5 mins";
                            else if (time <= 10) return "5-10 mins";
                            else if (time <= 15) return "10-15 mins";
                            else return "15+ mins";
                        },
                        Collectors.counting()
                ));
    }

    @GetMapping("/graph/3")
    @ResponseBody
    public Map<String, Integer> getObstaclesPerPath() {
        List<Delivery> deliveries = deliveryService.getAllDeliveries();
        return deliveries.stream()
                .collect(Collectors.groupingBy(
                        delivery -> delivery.getItemRequest().getPath().toString(),
                        Collectors.summingInt(Delivery::getNumberOfObstacles)
                ));
    }

    @GetMapping("/graph/4")
    @ResponseBody
    public Map<String, Long> getMostRequestedItem() {
        List<ItemRequest> itemRequests = itemRequestService.getAllItemRequests();
        return itemRequests.stream()
                .collect(Collectors.groupingBy(ItemRequest::getItem, Collectors.counting()));
    }

    @GetMapping("/graph/5")
    @ResponseBody
    public Map<String, Long> getRequestsPerMonth() {
        List<ItemRequest> itemRequests = itemRequestService.getAllItemRequests();
        return itemRequests.stream()
                .collect(Collectors.groupingBy(
                        itemRequest -> itemRequest.getRequestTime().getYear() + "-" + itemRequest.getRequestTime().getMonthValue(),
                        Collectors.counting()
                ));
    }

    @GetMapping("/graph/6")
    @ResponseBody
    public Map<String, Map<String, Long>> getItemPopularityTrends() {
        List<ItemRequest> itemRequests = itemRequestService.getAllItemRequests();

        Map<String, Map<String, Long>> result = itemRequests.stream()
                .collect(Collectors.groupingBy(
                        ItemRequest::getItem,
                        Collectors.groupingBy(
                                itemRequest -> itemRequest.getRequestTime().getYear() + "-" + itemRequest.getRequestTime().getMonthValue(),
                                Collectors.counting()
                        )
                ));

        Map<String, Long> totalCounts = itemRequests.stream()
                .collect(Collectors.groupingBy(
                        ItemRequest::getItem,
                        Collectors.counting()
                ));

        List<String> topItems = totalCounts.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();

        return result.entrySet().stream()
                .filter(entry -> topItems.contains(entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
