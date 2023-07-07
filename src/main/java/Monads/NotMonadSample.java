package Monads;

public class NotMonadSample {
    private double multiplyBy2(double n) {
        return n * 2;
    }

    private double divideBy2(double n) {
        return n / 2;
    }

    private double add3(double n) {
        return n + 3;
    }

    private double subtract1(double n) {
        return n - 1;
    }

    public double apply(double n) {
        return subtract1(add3(divideBy2(multiplyBy2(multiplyBy2(n)))));
    }
}
