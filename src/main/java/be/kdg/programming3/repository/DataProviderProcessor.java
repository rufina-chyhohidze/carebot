package be.kdg.programming3.repository;

import java.util.List;

/**
 * class that provides data for processor
 * If your data comes from a database or persistent storage, it belongs to the repository.
 * If it's dynamically generated or fetched from an external API, we place it in the service package.
 */
public class DataProviderProcessor {
    public static List<Double> distanceData() {
        return List.of(12.5, 15.3, 22.8, 9.4, 10.0);
    }

    public static List<Double> deliveryData() {
        return List.of(15.5, 16.3, 6.10, 9.4, 20.0);
    }
}