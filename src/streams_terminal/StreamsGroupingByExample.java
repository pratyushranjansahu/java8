package streams_terminal;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    }
}
