package streams;

import data.StudentDataBase;

public class StreamsMatchExample {

    private static boolean allMatch(){
        return StudentDataBase.getAllStudents()
                .stream()
                .allMatch(student -> student.getGpa() >= 4.1);
    }

    private static boolean anyMatch(){
        return StudentDataBase.getAllStudents()
                .stream()
                .anyMatch(student -> student.getGpa() >= 4.0);
    }

    private static boolean noneMatch(){
        return StudentDataBase.getAllStudents()
                .stream()
                .noneMatch(student -> student.getGpa() >= 4.1);
    }

    public static void main(String[] args) {
        System.out.println("AllMatch result is: "+allMatch());
        System.out.println("AnyMatch result is: "+anyMatch());
        System.out.println("NoneMatch result is: "+noneMatch());
    }
}
