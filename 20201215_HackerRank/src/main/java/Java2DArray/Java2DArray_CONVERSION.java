// Here let's List<String> -> List<List<Integer>>

package Java2DArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java2DArray_CONVERSION {
    public static void main(String[] args) {
        List<String> strings2 = new ArrayList<>(
                Arrays.asList(
                        "-9 -9 -9 1 1 1",
                        "0 -9 0 4 3 2",
                        "-9 -9 -9 1 2 3",
                        "0 0 8 6 6 0",
                        "0 0 0 -2 0 0",
                        "0 0 1 2 4 0"
                ));

        List<List<Integer>> result = convertListOfStrings(strings2);
        System.out.println(result);

    }

    public static List<List<Integer>> convertListOfStrings(List<String> list) {
        List<List<Integer>> converted = list.stream()
                .map(s -> Arrays.stream(s.split(" ")).map(Integer::parseInt).collect(Collectors.toList()))
                .collect(Collectors.toList());

        return converted;
    }

}
