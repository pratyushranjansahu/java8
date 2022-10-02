package numericstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamsBoxingUnBoxingExample {

    private static List<Integer> boxing(){
        return IntStream.rangeClosed(1,10)
                .boxed()
                .collect(Collectors.toList());
    }

    private static int unBoxing(List<Integer> integerList){
        return integerList.stream()
                .mapToInt(Integer :: intValue)
                .sum();
    }
    public static void main(String[] args) {

        System.out.println("Boxing : "+boxing());
        System.out.println("Un Boxing : "+unBoxing(boxing()));
    }
}
