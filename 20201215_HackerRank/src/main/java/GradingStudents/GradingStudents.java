package GradingStudents;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GradingStudents {
    static List<Integer> grades = new ArrayList<>();
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Collections.addAll(grades, 73, 67, 38, 33);
        System.out.println(gradingStudents(grades));
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        for (int grade : grades) {
            result.add(roundTheGrade(grade));
        }
        return result;
    }

    private static int roundTheGrade(int grade) {
        if (grade < 38 || grade % 5 == 0) return grade;
        int nextMultipleOf5 = grade - grade % 5 + 5;
        System.out.println(nextMultipleOf5);
        return grade + 2 < nextMultipleOf5 ? grade : nextMultipleOf5;
    }

}
