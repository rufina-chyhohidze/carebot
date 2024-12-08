package be.kdg.programming3.controller;

import be.kdg.programming3.domain.ItemRequest;
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
//
    public StatisticsController(ItemRequestService itemRequestService) {
        this.itemRequestService = itemRequestService;
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

}
