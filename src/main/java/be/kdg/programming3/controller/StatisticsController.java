package be.kdg.programming3.controller;

import be.kdg.programming3.domain.Delivery;
import be.kdg.programming3.domain.ItemRequest;
import be.kdg.programming3.service.DeliveryService;
import be.kdg.programming3.service.ItemRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class StatisticsController {
    private final ItemRequestService itemRequestService;
    private final DeliveryService deliveryService;
//
    public StatisticsController(ItemRequestService itemRequestService, DeliveryService deliveryService) {
        this.itemRequestService = itemRequestService;
        this.deliveryService = deliveryService;
    }

    @GetMapping("/statistics")
    public String showStatistics() {

        return "statistics";
    }

    @GetMapping("/statistics/graph1")
    @ResponseBody
    public Map<String, Long> getMostFrequentPath() {
        List<ItemRequest> itemRequests = itemRequestService.getAllItemRequests();
        return itemRequests.stream()
                .collect(Collectors.groupingBy(itemRequest -> itemRequest.getPath().toString(), Collectors.counting()));
    }

//    MAPPING FOR GRAPH2

    @GetMapping("/statistics/graph3")
    @ResponseBody
    public Map<String, Integer> getObstaclesPerPath() {
        List<ItemRequest> itemRequests = itemRequestService.getAllItemRequests();
        return itemRequests.stream()
                .collect(Collectors.groupingBy(
                        itemRequest -> itemRequest.getPath().toString(),
                        Collectors.summingInt(ItemRequest::getNumberOfObstacles)
                ));
    }

    @GetMapping("/statistics/graph4")
    @ResponseBody
    public Map<String, Long> getMostRequestedItem() {
        List<ItemRequest> itemRequests = itemRequestService.getAllItemRequests();
        return itemRequests.stream()
                .collect(Collectors.groupingBy(ItemRequest::getItem, Collectors.counting()));
    }

    @GetMapping("/statistics/graph5")
    @ResponseBody
    public Map<String, Long> getRequestsPerMonth() {
        List<ItemRequest> itemRequests = itemRequestService.getAllItemRequests();

        return itemRequests.stream()
                .collect(Collectors.groupingBy(
                        itemRequest -> itemRequest.getRequestTime().getYear() + "-" + itemRequest.getRequestTime().getMonthValue(),
                        Collectors.counting()
                ));
    }

//    EXPLORATIVE
    @GetMapping("/statistics/graph6")
    @ResponseBody
    public Map<String, Map<String, Long>> getItemPopularityTrends() {
        List<ItemRequest> itemRequests = itemRequestService.getAllItemRequests();

        Map<String, Map<String, Long>> result = itemRequests.stream()
                .collect(Collectors.groupingBy(
                        itemRequest -> itemRequest.getItem(),
                        Collectors.groupingBy(
                                itemRequest -> itemRequest.getRequestTime().getYear() + "-" + itemRequest.getRequestTime().getMonthValue(),
                                Collectors.counting()
                        )
                ));

        Map<String, Long> totalCounts = itemRequests.stream()
                .collect(Collectors.groupingBy(
                        itemRequest -> itemRequest.getItem(),
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

    @GetMapping("/statistics/graph2")
    @ResponseBody
    public Map<Integer, Double> getTimeTakenPerDelivery() {
        List<Delivery> deliveries = deliveryService.getAllDeliveries();
        return deliveries.stream()
                .collect(Collectors.toMap(
                        Delivery::getDeliveryId,
                        delivery -> {
                            if (delivery.getTotalDeliveryTime() != null) {
                                // Return total_delivery_time as it is (in minutes)
                                return (double) delivery.getTotalDeliveryTime(); // it's a Double
                            } else if (delivery.getDeliveryFinished() != null && delivery.getDeliveryStarted() != null) {
                                // Calculate time if not pre-computed
                                long timeTakenMillis =
                                        java.time.Duration.between(delivery.getDeliveryStarted(), delivery.getDeliveryFinished()).toMillis();
                                return timeTakenMillis / (60.0 * 1000.0); // converts milliseconds to minutes
                            } else {
                                return 0.0; // If data is incomplete
                            }
                        }
                ));
    }
}
