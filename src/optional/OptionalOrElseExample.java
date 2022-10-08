package optional;

import data.Student;
import data.StudentDataBase;

import java.util.Optional;

public class OptionalOrElseExample {

    private static void orElse(){
        System.out.println("orElse() with data");
        Optional<Student> optionalStudent = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        String name = optionalStudent.map(Student :: getName).orElse("Default");
        System.out.println("Student name : "+name);
        System.out.println("orElse() Without data");
        Optional<Student> optionalStudent1 = Optional.ofNullable(null);
        String name1 = optionalStudent1.map(Student :: getName).orElse("Default");
        System.out.println("Student name : "+name1);
        System.out.println("******************************");
    }

    private static void orElseGet(){
        System.out.println("orElseGet() with data");
        Optional<Student> optionalStudent = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        String name = optionalStudent.map(Student :: getName).orElseGet(()->"Default");
        System.out.println("Student name : "+name);
        System.out.println("orElseGet() Without data");
        Optional<Student> optionalStudent1 = Optional.ofNullable(null);
        String name1 = optionalStudent1.map(Student :: getName).orElseGet(()->"Default");
        System.out.println("Student name : "+name1);
        System.out.println("******************************");
    }

    private static void orElseThrow(){
        System.out.println("orElseThrow() with data");
        Optional<Student> optionalStudent = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        String name = optionalStudent.map(Student :: getName).orElseThrow(()->new RuntimeException("No data available."));
        System.out.println("Student name : "+name);
       /* System.out.println("orElseThrow() Without data");
        Optional<Student> optionalStudent1 = Optional.ofNullable(null);
        String name1 = optionalStudent1.map(Student :: getName).orElseThrow(()->new RuntimeException("No data available."));
        System.out.println("Student name : "+name1);*/
        System.out.println("******************************");
    }

    public static void main(String[] args) {
        orElse();
        orElseGet();
        orElseThrow();
    }
}
