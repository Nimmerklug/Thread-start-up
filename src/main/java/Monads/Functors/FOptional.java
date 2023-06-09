package Monads.Functors;

import java.util.function.Function;

class FOptional<T> implements Functor<T,FOptional<?>> {

    private final T valueOrNull;

    private FOptional(T valueOrNull) {
        this.valueOrNull = valueOrNull;
    }

    public <R> FOptional<R> map(Function<T,R> f) {
        if (valueOrNull == null)
            return empty();
        else
            return of(f.apply(valueOrNull));
    }

    public static <T> FOptional<T> of(T a) {
        return new FOptional<T>(a);
    }

    public static <T> FOptional<T> empty() {
        return new FOptional<T>(null);
    }

    FOptional<Integer> tryParse(String s) {
        try {
            final int i = Integer.parseInt(s);
            return FOptional.of(i);
        } catch (NumberFormatException e) {
            return FOptional.empty();
        }
    }

    @Override
    public String toString() {
        return "FOptional{" +
                "valueOrNull=" + valueOrNull +
                '}';
    }
}