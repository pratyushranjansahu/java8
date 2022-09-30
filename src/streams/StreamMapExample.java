package streams;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class StreamMapExample {

    private static List<String> namesList(){
        List<String> studentList = StudentDataBase.getAllStudents()
                .stream()
                .map(Student :: getName)
                .collect(toList());
        return studentList;
    }

    private static Set<String> namesSet(){
        Set<String> studentSet = StudentDataBase.getAllStudents()
                .stream()
                .map(Student :: getName)
                .collect(toSet());
        return studentSet;
    }

    public static void main(String[] args) {
        System.out.println(namesList());
        System.out.println(namesSet());
    }
}
