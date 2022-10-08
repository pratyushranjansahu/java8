package optional;

import data.Bike;
import data.Student;
import data.StudentDataBase;

import java.util.Optional;

public class OptionalMapFlatMapExample {

    private static void optionalFilter(){
        Optional<Student> optionalStudent =
                Optional.ofNullable(StudentDataBase.studentSupplier.get());
        optionalStudent.filter(student -> student.getGpa() >= 3.5)
                .ifPresent(student -> System.out.println(student));
    }

    private static void optionalMap(){
        Optional<Student> optionalStudent =
                Optional.ofNullable(StudentDataBase.studentSupplier.get());
        if (optionalStudent.isPresent()){
            String name = optionalStudent.filter(student -> student.getGpa() >= 3.5)
                    .map(Student::getName)
                    .get();
            System.out.println("Student name using map() : "+name);

        }
    }

    private static void optionalFlatMap(){
        Optional<Student> optionalStudent =
                Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<String> bikeName = optionalStudent.filter(student -> student.getGpa() >= 3.5)
                .flatMap(Student::getBike)
                .map(Bike::getName);
        bikeName.ifPresent(s -> System.out.println("Bike name is : "+bikeName.get()));
    }
    public static void main(String[] args) {
        optionalFilter();
        optionalMap();
        optionalFlatMap();
    }
}
