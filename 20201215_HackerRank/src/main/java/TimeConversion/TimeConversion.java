//https://www.hackerrank.com/challenges/time-conversion/problem

package TimeConversion;

public class TimeConversion {

    public static void main(String[] args) {
        System.out.printf("timeConversion(\"12:01:00AM\"): %s \n", timeConversion("12:01:00AM"));
        System.out.printf("timeConversion(\"12:57:12AM\"): %s \n", timeConversion("12:57:12AM"));
        System.out.printf("timeConversion(\"12:01:00PM\"): %s \n", timeConversion("12:01:00PM"));
        System.out.printf("timeConversion(\"06:01:00PM\"): %s \n", timeConversion("06:01:00PM"));
        System.out.printf("timeConversion(\"10:22:13PM\"): %s \n", timeConversion("10:22:13PM"));
    }

    static String timeConversion(String s) {
        String timeFormat = s.substring(s.length() - 2); // possible options: AM or PM
        String endOfString = s.substring(2, s.length() - 2);
        String hours = s.substring(0, 2);
        int hoursInt = Integer.parseInt(hours);

        switch (timeFormat) {
            case "AM":
                hours = hours.equals("12") ? "00" : hours;
                break;
            case "PM":
                if (hoursInt > 0 && hoursInt < 12)
                    hours = String.valueOf(hoursInt + 12);
                break;
        }

        return hours.concat(endOfString);
    }
}
