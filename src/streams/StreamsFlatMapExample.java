package streams;

import data.Student;
import data.StudentDataBase;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamsFlatMapExample {

    private static List<String> getActivities(){
        List<String> activities = StudentDataBase.getAllStudents()
                .stream()
                .map(Student :: getActivities)
                .flatMap(List :: stream)
                .distinct()
                .sorted()
                .collect(toList());
        return activities;
    }
    private static long getNumberOfActivities(){
        long numberOfactivities = StudentDataBase.getAllStudents()
                .stream()
                .map(Student :: getActivities)
                .flatMap(List :: stream)
                .distinct()
                .count();
        return numberOfactivities;
    }
    public static void main(String[] args) {
        System.out.println(getActivities());
        System.out.println(getNumberOfActivities());
    }
}
