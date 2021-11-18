//https://www.hackerrank.com/challenges/java-bigdecimal/problem
package JavaBigDecimal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaBigDecimal {
    public static void main(String[] args) {
        String[] input = {"-100", "50", "0", "56.6", "90", "0.12", ".12", "02.34", "000.000"};
        int n = input.length;
        String[] s = Arrays.copyOf(input, input.length);
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 1; j--) {
                if (new BigDecimal(s[j]).compareTo(new BigDecimal(s[j - 1])) > 0) {
                    String temp = s[j];
                    s[j] = s[j - 1];
                    s[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        System.out.printf("Result: %s \n", Arrays.toString(s));
        System.out.println("------------------------------------------------------------------");
        solutionUsingStreamsApi(input);
    }

    public static void solutionUsingStreamsApi(String[] input) {
        HashMap<String, BigDecimal> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            map.put(input[i], new BigDecimal(input[i]));
        }
        List<String> sortedList = map.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.printf("Result: %s \n", sortedList);
    }

}

// Expected output:
// [90, 56.6, 50, 02.34, 0.12, .12, 0, 000.000, -100]