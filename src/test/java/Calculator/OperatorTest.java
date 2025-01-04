package Calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @Test
    void testAddition() {
        double result = Operator.applyBinary("+", 5, 3);
        assertEquals(8, result, "5 + 3 should equal 8");
    }

    @Test
    void testSubtraction() {
        double result = Operator.applyBinary("-", 10, 4);
        assertEquals(6, result, "10 - 4 should equal 6");
    }

    @Test
    void testMultiplication() {
        double result = Operator.applyBinary("*", 7, 6);
        assertEquals(42, result, "7 * 6 should equal 42");
    }

    @Test
    void testDivision() {
        double result = Operator.applyBinary("/", 20, 4);
        assertEquals(5, result, "20 / 4 should equal 5");
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Operator.applyBinary("/", 10, 0);
        });
        assertEquals("Division by zero.", exception.getMessage());
    }

    @Test
    void testExponentiation() {
        double result = Operator.applyBinary("X^n", 2, 3);
        assertEquals(8, result, "2^3 should equal 8");
    }

    @Test
    void testRootWithN() {
        double result = Operator.applyBinary("n^√", 27, 3);
        assertEquals(3, result, "Cube root of 27 should equal 3");
    }

    @Test
    void testSquaring() {
        double result = Operator.applyUnary("X^2", 5);
        assertEquals(25, result, "5^2 should equal 25");
    }

    @Test
    void testSquareRoot() {
        double result = Operator.applyUnary("√", 16);
        assertEquals(4, result, "Square root of 16 should equal 4");
    }

    @Test
    void testSquareRootOfNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Operator.applyUnary("√", -4);
        });
        assertEquals("Negative number for square root.", exception.getMessage());
    }

    @Test
    void testFactorial() {
        double result = Operator.applyUnary("!", 5);
        assertEquals(120, result, "5! should equal 120");
    }

    @Test
    void testFactorialOfNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Operator.applyUnary("!", -3);
        });
        assertEquals("Factorial is undefined for non-integers or negatives.", exception.getMessage());
    }

    @Test
    void testSinus() {
        double result = Operator.applyUnary("sin", 30);
        assertEquals(0.5, result, 0.001, "sin(30) should equal 0.5");
    }

    @Test
    void testCosine() {
        double result = Operator.applyUnary("cos", 60);
        assertEquals(0.5, result, 0.001, "cos(60) should equal 0.5");
    }

    @Test
    void testTangent() {
        double result = Operator.applyUnary("tan", 45);
        assertEquals(1, result, 0.001, "tan(45) should equal 1");
    }

    @Test
    void testUnknownBinaryOperator() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Operator.applyBinary("?", 5, 5);
        });
        assertEquals("Unknown binary operator: ?", exception.getMessage());
    }

    @Test
    void testUnknownUnaryOperator() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Operator.applyUnary("?", 5);
        });
        assertEquals("Unknown unary operator: ?", exception.getMessage());
    }
}