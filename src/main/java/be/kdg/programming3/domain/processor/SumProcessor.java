package be.kdg.programming3.domain.processor;

import java.util.List;

public class SumProcessor implements DataProcessor {

    /**
     *
     * @param data
     * calculates the sum of provided numerical data
     */
    @Override
    public void processData(List<Double> data) {
        double sum = data.stream().mapToDouble(Double::doubleValue).sum();
        System.out.println("Sum of data: " + sum);
    }
}
