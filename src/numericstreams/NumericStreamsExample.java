package numericstreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamsExample {

    private static int sumOfNNumbers(List<Integer> integerList){
        return integerList.stream()
                .reduce(0,(a,b) -> a+b);
    }

    private static int sumOfNNumbersInteStream(){
        return IntStream.rangeClosed(1,6)
                .reduce(0,(a,b) -> a+b);
    }
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6);
        System.out.println("Sum of N numbers :  "+sumOfNNumbers(integerList));
        System.out.println("Sum of N numbers using int stream :  "+sumOfNNumbersInteStream());

    }
}
