package DayOfTheProgrammer;//https://www.hackerrank.com/challenges/day-of-the-programmer/problem

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DayOfProgrammer {

    public static void main(String[] args) {
        System.out.println(dayOfProgrammer(1800));
        System.out.println(dayOfProgrammer(1917));
        System.out.println(dayOfProgrammer(2017));
    }

//    Given a year, find the date of the 256th day of that year according
//    to the official Russian calendar during that year.

    static String dayOfProgrammer(int year) {
        if (year < 1700 || year > 2700) throw new IllegalStateException();

        int numbOfDaysIn8Months = 31 + calcNumbOfDaysInFeb(year) + 31 + 30 + 31 + 30 + 31 + 31;
        LocalDate date = LocalDate.of(year, 9, 256 - numbOfDaysIn8Months);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String result = dtf.format(date);

        return result;
    }

    private static int calcNumbOfDaysInFeb(int year) {
        if (year <= 1917) {
            return (year % 4 == 0) ? 29 : 28;
        } else if (year == 1918) {
            return 15;
        } else {
            boolean isLeapYearInGregorianCal = (year % 400 == 0) || ((year % 4) == 0) && (year % 100 != 0);
            return isLeapYearInGregorianCal ? 29 : 28;
        }
    }
}
