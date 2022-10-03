package streams_terminal;

import data.Student;
import data.StudentDataBase;

import java.util.stream.Collectors;

public class StreamsSumAverageExample {

    private static int sum(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.summingInt(Student::getNoteBooks));
    }

    private static double average(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.averagingInt(Student::getNoteBooks));
    }
    public static void main(String[] args) {
        System.out.println("Total No. of Notebook : "+sum());
        System.out.println("Average No. of Notebook : "+average());
    }
}
