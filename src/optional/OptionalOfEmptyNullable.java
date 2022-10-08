package optional;

import java.util.Optional;

public class OptionalOfEmptyNullable {

    private static Optional<String> ofNullable(){
        System.out.println("OfNullable()");
        Optional<String> stringOptional = Optional.ofNullable("Hello");
        Optional<String> stringOptional1 = Optional.ofNullable(null);
        System.out.println("Of Nullable with Data: "+stringOptional.get());
        System.out.println("Of Nullable without Data: "+stringOptional1);
        System.out.println("*****************************");
        return stringOptional;
    }

    private static void of(){
        System.out.println("Of()");
        Optional<String> stringOptional = Optional.of("Hello");
       // Optional<String> stringOptional1 = Optional.of(null);//Expect value
        System.out.println("Of with Data: "+stringOptional.get());
        //System.out.println("Of without Data: "+stringOptional1);
        System.out.println("*****************************");
    }

    private static void empty(){
        System.out.println("empty()");
        Optional<String> optionalEmpty = Optional.empty();
        System.out.println(optionalEmpty);
        System.out.println("*****************************");
    }
    public static void main(String[] args) {
        ofNullable();
        of();
        empty();
    }
}
