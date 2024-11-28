package be.kdg.programming3.domain.processor;

import java.util.List;

public class AverageProcessor implements DataProcessor{

    /**
     *
     * @param data
     * calculates the average of provided numerical data
     */
    @Override
    public void processData(List<Double> data) {
        double average = data.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        System.out.println("Average of data: " + average);
    }
}
