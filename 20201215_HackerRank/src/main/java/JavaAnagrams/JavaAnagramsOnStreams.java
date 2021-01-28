// https://www.hackerrank.com/challenges/java-anagrams/problem

package JavaAnagrams;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaAnagramsOnStreams {
    public static void main(String[] args) {
        boolean res1Bool = isAnagram("aaabcde", "bacadea");
        String res1Str = res1Bool ? "Anagrams" : "Not anagrams";
        System.out.println(res1Str);

        boolean res2Bool = isAnagram("super", "purse");
        String res2Str = res2Bool ? "Anagrams" : "Not anagrams";
        System.out.println(res2Str);

        boolean res3Bool = isAnagram("super", "pursee");
        String res3Str = res3Bool ? "Anagrams" : "Not anagrams";
        System.out.println(res3Str);
    }

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        Map<String, Long> aStrMapped =
                Arrays.stream(
                        a.split(""))
                        .collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        Map<String, Long> bStrMapped =
                Arrays.stream(
                        b.split(""))
                        .collect(Collectors.groupingBy(String::toString, Collectors.counting()));

//        System.out.println(aStrMapped);
//        System.out.println(bStrMapped);
        return aStrMapped.equals(bStrMapped);

    }
}
