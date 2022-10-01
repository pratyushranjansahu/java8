package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMinMaxExample {

    private static int findMaxValue(List<Integer> integerList){
        return integerList.stream()
                .reduce(0,(a,b)->a > b ? a : b);
    }

    private static Optional<Integer> findMaxValueWithOptional(List<Integer> integerList){
        return integerList.stream()
                .reduce((a,b)->a > b ? a : b);
    }

    private static Optional<Integer> findMinValue(List<Integer> integerList){
        return integerList.stream()
                .reduce((a,b)->a < b ? a : b);
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(6,7,8,9,10);
        System.out.println(findMaxValue(integerList));

        List<Integer> integerList1 = new ArrayList<>();
        if (findMaxValueWithOptional(integerList1).isPresent()){
            System.out.println(findMaxValueWithOptional(integerList1).get());
        }else {
            System.out.println("input string is empty.");
        }

        Optional<Integer> optionalInteger = findMinValue(integerList);
        if(optionalInteger.isPresent()){
            System.out.println("Min value is : "+optionalInteger.get());
        }else{
            System.out.println("List is empty.");
        }
    }
}
