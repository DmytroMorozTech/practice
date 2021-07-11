//https://www.hackerrank.com/challenges/java-2d-array/problem

// Article that turned out to be handy (re: Character.getNumericValue(char))
//https://stackoverflow.com/questions/46343616/how-can-i-convert-a-char-to-int-in-java/46343730
package Java2DArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java2DArray {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(
                Arrays.asList(
                        "1 1 1 0 0 0",
                        "0 1 0 0 0 0",
                        "1 1 1 0 0 0",
                        "0 0 2 4 4 0",
                        "0 0 0 2 0 0",
                        "0 0 1 2 4 0"
                ));

        List<String> stringsTrimmed = strings
                .stream()
                .map(s -> s.replace(" ", ""))
                .collect(Collectors.toList());

        int h = 6;
        int w = 6;
        int[][] data = new int[h][w];

        IntStream.range(0, h).forEach(y ->
                IntStream.range(0, w).forEach(x -> {
                    data[y][x] = Character.getNumericValue(stringsTrimmed.get(y).charAt(x));
                }));

        List<Integer> sumsOfHourglasses = new ArrayList<>();
        for (int y = 0; y <= 3; y++) {
            for (int x = 0; x <= 3; x++) {
                sumsOfHourglasses.add(calculateHourglassSum(data, y, x));
            }
        }

        Integer max = Collections.max(sumsOfHourglasses);
        System.out.println(max);
    }


    public static int calculateHourglassSum(int[][] data, int y, int x) {
        return data[y][x] + data[y][x + 1] + data[y][x + 2]
                + data[y + 1][x + 1]
                + data[y + 2][x] + data[y + 2][x + 1] + +data[y + 2][x + 2];
    }
}
