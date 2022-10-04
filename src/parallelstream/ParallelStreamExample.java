package parallelstream;

import java.util.stream.IntStream;

public class ParallelStreamExample {

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
        System.out.println(sequentialStream());
        System.out.println(parallelStream());
    }
}
