package MagicSquare;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class MagicSquare {
    public static void main(String[] args) {
        int[][] s = {
                {5, 3, 4},
                {1, 5, 8},
                {6, 4, 2}
        };
//        formingMagicSquare(s);
    }

//    static int formingMagicSquare(int[][] s) {
//        int magicNumb = 15;
//        Set<Integer> nonUsedNumbers = new HashSet<>();
//        flatten(s).forEach(number -> nonUsedNumbers.add((Integer) number));
//        System.out.println(nonUsedNumbers);
//        return 3;
//    }
//
//    private static Stream<Object> flatten(Object[] array) {
//        return Arrays.stream(array)
//                     .flatMap(o -> o instanceof Object[] ? flatten((Object[]) o) : Stream.of(o));
//    }
}
