package parallelstream;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamExample {

    private static long checkPerformance(Supplier<Integer> supplier, int numberOfTimes){
        long start = System.currentTimeMillis();
        for (int i = 0; i < numberOfTimes; i++) {
            supplier.get();
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }
    private static int sequentialStream(){
        return IntStream.rangeClosed(1,100000)
                .sum();
    }

    private static int parallelStream(){
        return IntStream.rangeClosed(1,100000)
                .parallel()
                .sum();
    }
    public static void main(String[] args) {
        System.out.println("Sequential Stream Result : "+checkPerformance(ParallelStreamExample::sequentialStream,20));
        System.out.println("Parallel Stream Result : "+checkPerformance(ParallelStreamExample::parallelStream,20));
    }
}
