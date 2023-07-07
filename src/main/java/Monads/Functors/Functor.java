package Monads.Functors;

import java.util.function.Function;

interface Functor<T,F extends Functor<?,?>> {
    // functor is a typed data structure that encapsulates some value(s)
    <R> F map(Function<T,R> f);
   // <R> Functor<R> map(Function<T, R> f);
    //The only operation that functor provides is map() that takes a function f
}
