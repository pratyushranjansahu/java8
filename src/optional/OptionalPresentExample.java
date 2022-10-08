package optional;

import java.util.Optional;

public class OptionalPresentExample {

    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable("Hello");
        Optional<String> optional1 = Optional.ofNullable(null);

        System.out.println("Optional.isPresent() with data : "+optional.isPresent());
        System.out.println("Optional.isPresent() without data : "+optional1.isPresent());

        optional.ifPresent(s -> System.out.println(s));
        optional1.ifPresent(s -> System.out.println(s));//won't print anything
    }
}
