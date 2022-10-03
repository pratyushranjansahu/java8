package streams_terminal;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamsMappingExample {

    public static void main(String[] args) {
        List<String> nameList = StudentDataBase.getAllStudents()
                .stream()
                .collect(mapping(Student::getName,toList()));

        Set<String> nameSet = StudentDataBase.getAllStudents()
                .stream()
                .collect(mapping(Student::getName,toSet()));

        System.out.println("nameList : "+nameList);
        System.out.println("nameSet : "+nameSet);
    }
}
