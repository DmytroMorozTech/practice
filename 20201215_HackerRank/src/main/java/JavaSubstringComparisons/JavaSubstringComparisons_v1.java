// solution with usage of ArrayList.
// It turned out to be forbidden by CodeWars for this task.

package JavaSubstringComparisons;

import java.util.ArrayList;
import java.util.List;

public class JavaSubstringComparisons_v1 {
    public static String s = "welcometojava";

    public static void main(String[] args) {
        System.out.println(getSmallestAndLargest(s, 3));
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        List<String> subStrings = new ArrayList<>();

        for (int i = 0; i <= s.length() - k; i++) {
            String subStr = s.substring(i, i + k);
            subStrings.add(subStr);
        }
        subStrings.sort(String::compareTo);

        smallest = subStrings.get(0);
        largest = subStrings.get(subStrings.size() - 1);

        return smallest + "\n" + largest;
    }
}
