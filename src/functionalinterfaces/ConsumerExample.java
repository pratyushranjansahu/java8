package functionalinterfaces;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    static Consumer<Student> c2 = s -> System.out.println(s);
    static Consumer<Student> c3 = s -> System.out.print(s.getName());
    static Consumer<Student> c4 = s -> System.out.println(s.getActivities());

    private static void printStudent() {
        System.out.println("*****printStudent********");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(c2);
    }

    private static void printNameAndActivities() {
        System.out.println("*****printNameAndActivities********");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(c3.andThen(c4));
    }

    private static void printNameAndActivitiesUsingConditions() {
        System.out.println("*****printNameAndActivitiesUsingConditions********");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach((student -> {
            if(student.getGradeLevel() >= 3.0 && student.getGpa() >= 3.9){
                c3.andThen(c4).accept(student);
            }
        }));
    }
    public static void main(String[] args) {
        Consumer<String> c1 = s -> System.out.println(s.toUpperCase());
        c1.accept("java8");
        printStudent();
        printNameAndActivities();
        printNameAndActivitiesUsingConditions();
    }
}
