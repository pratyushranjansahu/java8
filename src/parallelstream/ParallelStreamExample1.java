package parallelstream;

import data.Student;
import data.StudentDataBase;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ParallelStreamExample1 {

    private static List<String> sequentialStreamGetActivities(){
        long startTime = System.currentTimeMillis();
        List<String> activities = StudentDataBase.getAllStudents()
                .stream()
                .map(Student:: getActivities)
                .flatMap(List :: stream)
                .distinct()
                .sorted()
                .collect(toList());

        long endTime = System.currentTimeMillis();
        System.out.println("Sequential Stream : "+(endTime - startTime));
        return activities;
    }

    private static List<String> parallelStreamGetActivities(){
        long startTime = System.currentTimeMillis();
        List<String> activities = StudentDataBase.getAllStudents()
                .stream()
                .parallel()
                .map(Student:: getActivities)
                .flatMap(List :: stream)
                .distinct()
                .sorted()
                .collect(toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Parallel Stream : "+(endTime - startTime));
        return activities;
    }

    public static void main(String[] args) {
        System.out.println(sequentialStreamGetActivities());
        System.out.println(parallelStreamGetActivities());
    }
}
