package streams_terminal;

import data.Student;
import data.StudentDataBase;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamsGroupingByExample {

    private static void groupingByGender(){
        Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGender));
        System.out.println(studentMap);
    }

    private static void customizedGroupingBy(){
        Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"));
        System.out.println(studentMap);
    }

    private static void twoLevelGrouping_1(){
        Map<Integer,Map<String, List<Student>>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")));
        System.out.println(studentMap);
    }

    private static void twoLevelGrouping_2(){
        Map<Integer,Integer> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,Collectors.summingInt(Student::getNoteBooks)));
        System.out.println(studentMap);
    }

    private static void twoLevelGrouping_2a(){
        Map<String,Integer> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getName,Collectors.summingInt(Student::getNoteBooks)));
        System.out.println(studentMap);
    }

    private static void threeArgumentGroupBy(){
        LinkedHashMap<String, Set<Student>> studentSet = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getName, LinkedHashMap::new,toSet()));
        System.out.println(studentSet);
    }

    private static void calculateTopGPA(){
        Map<Integer, Optional<Student>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,maxBy(Comparator.comparing(Student::getGpa))));
        System.out.println(studentMap);
        System.out.println("Extracting from Optional");
        Map<Integer, Student> studentMap1 = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,collectingAndThen(maxBy(Comparator.comparing(Student::getGpa)),Optional::get)));
        System.out.println(studentMap1);
    }

    private static void calculateLeastGPA(){
        Map<Integer, Optional<Student>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,minBy(Comparator.comparing(Student::getGpa))));
        System.out.println(studentMap);
        System.out.println("Extracting from Optional");
        Map<Integer, Student> studentMap1 = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,collectingAndThen(minBy(Comparator.comparing(Student::getGpa)),Optional::get)));
        System.out.println(studentMap1);
    }

    private static void partitioningBy_1(){

        Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.8;
        Map<Boolean,List<Student>> studentList = StudentDataBase.getAllStudents()
                .stream()
                .collect(partitioningBy(gpaPredicate));
        System.out.println(studentList);
    }

    private static void partitioningBy_2(){

        Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.8;
        Map<Boolean,Set<Student>> studentList = StudentDataBase.getAllStudents()
                .stream()
                .collect(partitioningBy(gpaPredicate,toSet()));
        System.out.println(studentList);
    }
    public static void main(String[] args) {
        System.out.println("Grouping By");
        groupingByGender();
        System.out.println("Customize Grouping By");
        customizedGroupingBy();
        System.out.println("twoLevelGrouping_1 Grouping By");
        twoLevelGrouping_1();
        System.out.println("twoLevelGrouping_2 Grouping By");
        twoLevelGrouping_2();
        System.out.println("twoLevelGrouping_2a Grouping By");
        twoLevelGrouping_2a();
        System.out.println("threeArgumentGroupBy Grouping By");
        threeArgumentGroupBy();
        System.out.println("calculateTopGPA()");
        calculateTopGPA();
        System.out.println("calculateLeastGPA()");
        calculateLeastGPA();
        System.out.println("partitioningBy_1()");
        partitioningBy_1();
        System.out.println("partitioningBy_2()");
        partitioningBy_2();
    }
}
