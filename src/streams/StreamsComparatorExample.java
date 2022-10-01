package streams;

import data.Student;
import data.StudentDataBase;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamsComparatorExample {
    private static List<Student> sortStudentByName(){
        return StudentDataBase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student :: getName))
                .collect(toList());
    }
    private static List<Student> sortStudentByGPA(){
        return StudentDataBase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student :: getGpa))
                .collect(toList());
    }
    private static List<Student> sortStudentByGPADesc(){
        return StudentDataBase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student :: getGpa).reversed())
                .collect(toList());
    }
    public static void main(String[] args) {
        System.out.println("Sort Student by Name");
        sortStudentByName().forEach(System.out :: println);
        System.out.println("Sort Student by GPA");
        sortStudentByGPA().forEach(System.out :: println);
        System.out.println("Sort Student by GPA DESC");
        sortStudentByGPADesc().forEach(System.out :: println);
    }
}
