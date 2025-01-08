package Calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Operator {
    private static final Map<String, BiFunction<Double, Double, Double>> BINARY_OPERATORS = new HashMap<>();
    private static final Map<String, Function<Double, Double>> UNARY_OPERATORS = new HashMap<>();

    static {
        // Define binary operators
        BINARY_OPERATORS.put("+", Operator::add);
        BINARY_OPERATORS.put("-", Operator::subtract);
        BINARY_OPERATORS.put("*", Operator::multiply);
        BINARY_OPERATORS.put("/", Operator::divide);
        BINARY_OPERATORS.put("X^n", Operator::exponentiation);
        BINARY_OPERATORS.put("n^√", Operator::rootWithN);

        // Define unary operators
        UNARY_OPERATORS.put("X^2", Operator::squaring);
        UNARY_OPERATORS.put("√", Operator::squareRoot);
        UNARY_OPERATORS.put("!", Operator::factorial);
        UNARY_OPERATORS.put("sin", Operator::sinus);
        UNARY_OPERATORS.put("cos", Operator::cosine);
        UNARY_OPERATORS.put("tan", Operator::tangent);
    }

    // Binary operator methods
    private static double add(double a, double b) {
        return a + b;
    }

    private static double subtract(double a, double b) {
        return a - b;
    }

    private static double multiply(double a, double b) {
        return a * b;
    }

    private static double divide(double a, double b) {
        if (b == 0) throw new IllegalArgumentException("Division by zero.");
        return a / b;
    }

    private static double exponentiation(double a, double b) {
        return Math.pow(a, b);
    }

    private static double rootWithN(double a, double b) {
        if (a < 0) throw new IllegalArgumentException("Negative base for root.");
        return Math.pow(a, 1 / b);
    }

    // Unary operator methods
    private static double squaring(double a) {
        return a * a;
    }

    private static double squareRoot(double a) {
        if (a < 0) throw new IllegalArgumentException("Negative number for square root.");
        return Math.sqrt(a);
    }

    private static double factorial(double a) {
        if (a < 0 || a != Math.floor(a)) throw new IllegalArgumentException("Factorial is undefined for non-integers or negatives.");
        int result = 1;
        for (int i = 1; i <= (int) a; i++) {
            result *= i;
        }
        return result;
    }

    private static double sinus(double a) {
        return Math.sin(Math.toRadians(a));
    }

    private static double cosine(double a) {
        return Math.cos(Math.toRadians(a));
    }

    private static double tangent(double a) {
        return Math.tan(Math.toRadians(a));
    }


    public static boolean isBinaryOperator(String operator) {
        return BINARY_OPERATORS.containsKey(operator);
    }

    public static boolean isUnaryOperator(String operator) {
        return UNARY_OPERATORS.containsKey(operator);
    }
    // Access methods for calculator
    public static double applyBinary(String operator, double a, double b) {
        if (!isBinaryOperator(operator)) {
            throw new IllegalArgumentException("Unknown binary operator: " + operator);
        }
        return BINARY_OPERATORS.get(operator).apply(a, b);
    }

    public static double applyUnary(String operator, double a) {
        if (!isUnaryOperator(operator)) {
            throw new IllegalArgumentException("Unknown unary operator: " + operator);
        }
        return UNARY_OPERATORS.get(operator).apply(a);
    }
}