package by.itacademy.laptsionak;

public class Calculator {

    public int sum(int a, int b) {
        return Math.addExact(a, b);
    }

    public int multiply(int a, int b) {
        return Math.multiplyExact(a, b);
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }

    public int subtract(int a, int b) {
        return Math.subtractExact(a, b);
    }
}
