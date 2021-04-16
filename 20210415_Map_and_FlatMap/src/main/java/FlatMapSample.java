import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlatMapSample {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("1", "2", "3",
//                "4", "5");
//
//        R collect = list.stream().flatMapToInt(num -> IntStream.of(Integer.parseInt(num))).collect(Collectors.toList());

        List<String> words = Arrays.asList("JavaStreamApi", "JavaIsGreat");
        // Let's assume that we need to find the List of unique letters from the words in the above list.
        // solution using flatMap() goes here:
        List<String> collect = words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
//                .flatMap(w -> Arrays.stream(w.split("")))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
