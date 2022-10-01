package streams;

import data.Student;
import data.StudentDataBase;

import java.util.Optional;

public class StreamsFindAnyFirstExample {

    private static Optional<Student> findAny(){
        return StudentDataBase.getAllStudents()
                .stream()
                .filter(student -> student.getGpa() >= 3.9)
                .findAny();
    }

    private static Optional<Student> findFirst(){
        return StudentDataBase.getAllStudents()
                .stream()
                .filter(student -> student.getGpa() >= 3.9)
                .findFirst();
    }
    public static void main(String[] args) {
        Optional<Student> optionalStudentFindAny = findAny();
        if (optionalStudentFindAny.isPresent()){
            System.out.println("Found Student using findAny() : "+optionalStudentFindAny.get());
        }else {
            System.out.println("No Student found ");
        }

        Optional<Student> optionalStudentFindFirst = findFirst();
        if (optionalStudentFindFirst.isPresent()){
            System.out.println("Found Student using findFirst() : "+optionalStudentFindFirst.get());
        }else {
            System.out.println("No Student found ");
        }
    }
}
