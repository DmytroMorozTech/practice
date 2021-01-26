// https://www.hackerrank.com/challenges/between-two-sets/problem

package BetweenTwoSets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BetweenTwoSets {
    private static List<Integer> a = new ArrayList<>(Arrays.asList(2, 4));
    private static List<Integer> b = new ArrayList<>(Arrays.asList(16, 32, 96));
    private static List<Integer> res1 = new ArrayList<>();
    private static List<Integer> res2 = new ArrayList<>();

    public static void main(String[] args) {
        int result = getTotalX(a, b);
        System.out.println(result);
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int minPossibleVal = a.get(a.size() - 1);
        int maxPossibleVal = b.get(0);
//        System.out.printf("%d %d", minPossibleVal, maxPossibleVal);

        for (int i = minPossibleVal; i <= maxPossibleVal; i++) {
            int counter = 0;
            for (int aNumb : a) {
                counter = isDivisible(i, aNumb) ? counter : counter + 1;
            }
            if (counter == 0) res1.add(i);
        }

        for (int r1 : res1) {
            int counter = 0;
            for (int bNumb : b) {
                counter = isDivisible(bNumb, r1) ? counter : counter + 1;
            }
            if (counter == 0) res2.add(r1);
        }
        return res2.size();
    }

    public static boolean isDivisible(int dividend, int divisor) {
        return dividend % divisor == 0;
    }
}
