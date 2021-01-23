//https://www.hackerrank.com/challenges/java-date-and-time/problem
package JavaDateAndTime;

import java.time.*;
import java.util.*;

public class JavaDateAndTime {
    private static List<String> inputData = new ArrayList<>();

    public static void main(String[] args) {
        // pattern for data is MM DD YYYY
        Collections.addAll(inputData,
                           "08 05 2015", // WEDNESDAY
                           "11 25 2021", // THURSDAY
                           "06 19 2026" //FRIDAY
        );

        for (String date: inputData) {
            String[] multipleInput = date.split(" ");
            int month = Integer.parseInt(multipleInput[0]);
            int day = Integer.parseInt(multipleInput[1]);
            int year = Integer.parseInt(multipleInput[2]);

            System.out.println(findDay(month,day,year));
        }
    }

    public static String findDay(int month, int day, int year) {
        LocalDate localDate = LocalDate.of(year,month,day);
        return localDate.getDayOfWeek().toString();
    }
}
