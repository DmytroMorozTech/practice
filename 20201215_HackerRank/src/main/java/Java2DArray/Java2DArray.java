//https://www.hackerrank.com/challenges/java-2d-array/problem

package Java2DArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Java2DArray {
    public static void main(String[] args) {
        List<List<Integer>> srcData1 = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(1, 1, 1, 0, 0, 0),
                        Arrays.asList(0, 1, 0, 0, 0, 0),
                        Arrays.asList(1, 1, 1, 0, 0, 0),
                        Arrays.asList(0, 0, 2, 4, 4, 0),
                        Arrays.asList(0, 0, 0, 2, 0, 0),
                        Arrays.asList(0, 0, 1, 2, 4, 0))
        );

        List<List<Integer>> srcData2 = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(-9, -9, -9, 1, 1, 1),
                        Arrays.asList(0, -9, 0, 4, 3, 2),
                        Arrays.asList(-9, -9, -9, 1, 2, 3),
                        Arrays.asList(0, 0, 8, 6, 6, 0),
                        Arrays.asList(0, 0, 0, -2, 0, 0),
                        Arrays.asList(0, 0, 1, 2, 4, 0))
        );

        System.out.println("MaxHourglassSum in 2D array (DATASET No.1): ");
        System.out.println(calculateMaxHourglassSum(srcData1));

        System.out.println("MaxHourglassSum in 2D array (DATASET No.2): ");
        System.out.println(calculateMaxHourglassSum(srcData2));
    }


    public static int calculateMaxHourglassSum(List<List<Integer>> input) {
        List<Integer> sumsOfHourglasses = new ArrayList<>();
        for (int y = 0; y <= 3; y++) {
            for (int x = 0; x <= 3; x++) {
                sumsOfHourglasses.add(calculateHourglassSum(input, y, x));
            }
        }

        return Collections.max(sumsOfHourglasses);
    }

    public static int calculateHourglassSum(List<List<Integer>> data, int y, int x) {
        return data.get(y).get(x) + data.get(y).get(x + 1) + data.get(y).get(x + 2)
                + data.get(y + 1).get(x + 1)
                + data.get(y + 2).get(x) + data.get(y + 2).get(x + 1) + data.get(y + 2).get(x + 2);
    }
}
