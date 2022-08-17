package pro.sky.java.course2.springcoredemo.services;

import org.springframework.stereotype.Service;

@Service
public class PerfectWeightCalculatorImpl  implements PerfectWeightCalculator{
    @Override
    public int calculate(int height) {
        return (int) ((height - 100) * 1.15);
    }
    private static PerfectWeightCalculatorImpl instance;

    public static PerfectWeightCalculatorImpl getInstance() {
        if (instance == null) {
            instance = new PerfectWeightCalculatorImpl();
        }
        return instance;
    }
}
