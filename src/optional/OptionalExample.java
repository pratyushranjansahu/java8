package optional;

import data.Student;
import data.StudentDataBase;

import java.util.Optional;

public class OptionalExample {

    private static Optional<String> getStudentNameOptional(){
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        //Optional<Student> studentOptional = Optional.ofNullable(null);
        if (studentOptional.isPresent()){
            return studentOptional.map(Student :: getName);
        }
        return Optional.empty();
    }
    public static void main(String[] args) {
        Optional<String> optionalStudent = getStudentNameOptional();
        if (optionalStudent.isPresent()){
            System.out.println("Student name length is : "+optionalStudent.get().length());
        }else {
            System.out.println("No Student Found");
        }
    }
}
