// https://www.codewars.com/kata/554b4ac871d6813a03000035/solutions/javascript

package HighestAndLowest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HighestAndLowest {
    public static void main(String[] args) {
        System.out.println(highAndLow("1 2 -5 3 4 -80 5 19 -42"));
    }

    public static String highAndLow(String numbers) {
        String[] s = numbers.split(" ");
        if (s.length == 1) return s[0] + " " + s[0];
        List<Integer> arrOfNumb = Arrays
                .stream(s)
                .map(item -> Integer.parseInt(item))
                .collect(Collectors.toList());
        System.out.printf("Initial array of numbers: %s\n", arrOfNumb);

        List<Integer> sortedNumbers = arrOfNumb.stream().sorted().collect(Collectors.toList());
        System.out.printf("Sorted array of numbers: %s\n", sortedNumbers);
        int minVal = sortedNumbers.get(0);
        int maxVal = sortedNumbers.get(sortedNumbers.size() - 1);
        System.out.println(sortedNumbers);
        System.out.println(minVal);
        System.out.println(maxVal);
        return maxVal + " " + minVal;
    }
}
