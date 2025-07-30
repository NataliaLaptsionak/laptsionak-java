package by.itacademy.laptsionak;

public class Calculator implements ICalculator {
    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int multiplay(int a, int b) { // Вероятно, опечатка в названии метода, должно быть "multiply"
        return 0;
    }

    @Override
    public double divide(int a, int b) {
        return 0;
    }

    @Override
    public int subtract(int a, int b) {
        return 0;
    }
}
