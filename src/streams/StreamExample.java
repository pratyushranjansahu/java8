package streams;

import data.Student;
import data.StudentDataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        Predicate<Student> gradePredicate = student -> student.getGradeLevel() >= 3;
        Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.9;
        Map<String, List<String>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .peek(student -> {
                    System.out.println(student);
                })
                .filter(gradePredicate)
                .peek(student -> {
                    System.out.println("after 1st filter : "+student);
                })
                .filter(gpaPredicate)
                .peek(student -> {
                    System.out.println("after 2nd filter : "+student);
                })
                .collect(Collectors.toMap(Student :: getName, Student :: getActivities));
        System.out.println(studentMap);

    }
}
