package Monads.Functors;

public class Main {
    public static void main(String[] args) {
        Identity<String> idString = new Identity<>("abc");
        System.out.println(idString);

        Identity<Integer> idInt = idString.map(String::length);
        System.out.println(idInt);

        FOptional<String> str = FOptional.of("42");
        System.out.println(str);
        FOptional<FOptional<Integer>> num = str.map(str::tryParse);
        System.out.println(num);
    }
}
