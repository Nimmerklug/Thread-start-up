package Monads;

import java.util.Optional;

public class MonadSample {
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
        return Optional.of(n)
                .flatMap(value -> Optional.of(multiplyBy2(value)))
                .flatMap(value -> Optional.of(multiplyBy2(value)))
                .flatMap(value -> Optional.of(divideBy2(value)))
                .flatMap(value -> Optional.of(add3(value)))
                .flatMap(value -> Optional.of(subtract1(value)))
                .get();
    }
}
