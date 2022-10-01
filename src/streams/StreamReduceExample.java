package streams;

import data.Student;
import data.StudentDataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {

    private static int performMultiplication(List<Integer> intergerList) {
        return intergerList.stream()
                .reduce(1,(a,b) -> a * b);
    }

    private static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> intergerList) {
        return intergerList.stream()
                .reduce((a,b) -> a * b);
    }

    private static Optional<Student> getHighestStudentGPA() {
        return StudentDataBase.getAllStudents()
                .stream()
                .reduce((s1,s2) -> s1.getGpa() > s2.getGpa() ? s1 : s2);
    }
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,3,5,7);
        System.out.println(performMultiplication(integers));
        System.out.println(performMultiplicationWithoutIdentity(integers).get());

        List<Integer> integers1 = new ArrayList<>();
        System.out.println(performMultiplicationWithoutIdentity(integers1).isPresent());
        if(performMultiplicationWithoutIdentity(integers1).isPresent()){
            System.out.println(performMultiplicationWithoutIdentity(integers1).get());
        }

        Optional<Student> optionalStudent = getHighestStudentGPA();
        if(optionalStudent.isPresent()){
            System.out.println(optionalStudent.get());
        }
    }
}
