package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NumberAscOrder {
    private CustomStack<Number> customStack;

    public NumberAscOrder(CustomStack<Number> customStack) {
        this.customStack = customStack;
    }

    public List<Number> sort() throws StackEmptyException {
        List<Number> numbers = new ArrayList<>();

        while (!customStack.isEmpty()) {
            numbers.add(customStack.pop()); 
        }

        Collections.sort(numbers, new Comparator<Number>() {
            @Override
            public int compare(Number num1, Number num2) {
                return Double.compare(num1.doubleValue(), num2.doubleValue());
            }
        });

        return numbers;
    }
}
