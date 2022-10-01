package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsLimitSkipExample {

    private static Optional<Integer> limit(List<Integer> integerList){
        return integerList.stream()
                .limit(3)
                .reduce((a,b) -> a+b);
    }

    private static Optional<Integer> skip(List<Integer> integerList){
        return integerList.stream()
                .skip(3)
                .reduce((a,b) -> a+b);
    }

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(6,7,8,9,10);
        Optional<Integer> optionalInteger = limit(integerList);
        if (optionalInteger.isPresent()){
            System.out.println("The limit result is: "+optionalInteger.get());
        }else {
            System.out.println("No input is passed.");
        }

        optionalInteger = skip(integerList);
        if (optionalInteger.isPresent()){
            System.out.println("The skip result is: "+optionalInteger.get());
        }else {
            System.out.println("No input is passed.");
        }
    }
}
