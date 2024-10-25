//package be.kdg.programming3.service;
//
//import be.kdg.programming3.domain.Delivery;
//import be.kdg.programming3.repository.DeliveryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class DataServiceImpl {
//
//    private final DeliveryRepository deliveryRepository;
//
//    @Autowired
//    public DataServiceImpl(DeliveryRepository deliveryRepository) {
//        this.deliveryRepository = deliveryRepository;
//    }
//
////    public List<List<Object>> retrieveDataInformation(int orderBY, boolean ascending) {
////        List<List<Object>> allRows = new ArrayList<>();
////
////        List<Delivery> deliveries;
////        if (ascending) {
////            deliveries = deliveryRepository.findAllByOrderByDeliveryTimeAsc(); // Assuming you're ordering by delivery time
////        } else {
////            deliveries = deliveryRepository.findAllByOrderByDeliveryTimeDesc();
////        }
////
////        for (Delivery delivery : deliveries) {
////            List<Object> row = new ArrayList<>();
////            row.add(delivery.getDeliveryId());
////            row.add(delivery.getEmployeeId());
////            row.add(delivery.getDeliveryTime());
////            allRows.add(row);
////        }
////        return allRows;
////    }
//}
