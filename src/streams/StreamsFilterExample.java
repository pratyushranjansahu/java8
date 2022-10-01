package streams;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamsFilterExample {
    private static List<Student> getFilterStudent(){
        return StudentDataBase.getAllStudents()
                .stream()
                .filter(student -> student.getGender().equals("female"))
                .filter(student -> student.getGpa() >= 3.9)
                .collect(toList());
    }
    public static void main(String[] args) {
        getFilterStudent().forEach(System.out :: println);
    }
}
