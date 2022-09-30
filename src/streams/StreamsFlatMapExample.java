package streams;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamsFlatMapExample {

    private static List<String> getActivities(){
        List<String> activities = StudentDataBase.getAllStudents()
                .stream()
                .map(Student :: getActivities)
                .flatMap(List :: stream)
                .collect(toList());
        return activities;
    }
    public static void main(String[] args) {
        System.out.println(getActivities());
    }
}
