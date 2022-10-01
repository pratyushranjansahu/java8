package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {
    private static int performMultiplication(List<Integer> intergerList) {
        return intergerList.stream()
                .reduce(1,(a,b) -> a * b);
    }

    private static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> intergerList) {
        return intergerList.stream()
                .reduce((a,b) -> a * b);
    }
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,3,5,7);
        System.out.println(performMultiplication(integers));
        System.out.println(performMultiplicationWithoutIdentity(integers).get());

        List<Integer> integers1 = new ArrayList<>();
        System.out.println(performMultiplicationWithoutIdentity(integers1).isPresent());
        if(performMultiplicationWithoutIdentity(integers1).isPresent()){
            System.out.println(performMultiplicationWithoutIdentity(integers1).get());
        }
    }
}
