package functionalinterfaces;

import java.util.function.Function;

public class FunctionExample {

    static Function<String, String> function = (name) -> name.toUpperCase();
    static Function<String, String> addSomeString = (name) -> name.toUpperCase().concat("default");

    public static void main(String[] args) {
        System.out.println("Result is : "+function.andThen(addSomeString).apply("Java8"));
        System.out.println("Result using compose is : "+function.compose(addSomeString).apply("Java8"));
    }
}
