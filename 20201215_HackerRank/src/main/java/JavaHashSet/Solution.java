//https://www.hackerrank.com/challenges/java-hashset/problem
package JavaHashSet;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    static String[] pair_left = new String[5];
    static String[] pair_right = new String[5];

    public static void main(String[] args) {
        initializeDataStructure();
        Set uniqueStrSet = new HashSet();
        for (int i = 0; i < pair_left.length; i++) {
            String newStr = pair_left[i] + " " + pair_right[i];
            uniqueStrSet.add(newStr);
            System.out.println(uniqueStrSet.size());
        }
    }

    private static void initializeDataStructure() {
        pair_left[0] = "john";
        pair_left[1] = "john";
        pair_left[2] = "john";
        pair_left[3] = "mary";
        pair_left[4] = "mary";

        pair_right[0] = "tom";
        pair_right[1] = "mary";
        pair_right[2] = "tom";
        pair_right[3] = "anna";
        pair_right[4] = "anna";
    }
}
