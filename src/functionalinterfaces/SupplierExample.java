package functionalinterfaces;

import data.Student;
import data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
        Supplier<Student> studentSupplier = () ->{
            return new Student("Adam",2,3.6, "male",10, Arrays.asList("swimming", "basketball","volleyball"));
        };
        System.out.println("Student is : "+studentSupplier.get());

        Supplier<List<Student>> listStudentSupplier = () ->{
            return StudentDataBase.getAllStudents();
        };
        System.out.println("Students are : "+listStudentSupplier.get());
    }
}
