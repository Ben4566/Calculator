package Calculator;

import java.util.ArrayList;
import java.util.List;

public class Logic {

    List<Double> doubleList = new ArrayList<>();
    private double firstNumber;
    private double secondNumber;
    private String operator;

    public void setNumber(double number) {
        doubleList.add(number);
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double calculate() throws ArithmeticException {
        double result = 0;
        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                result = firstNumber / secondNumber;
                break;
        }
        return result;
    }
}


