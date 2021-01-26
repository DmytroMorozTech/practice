// This solution was the final one that was accepted by HackerRank.
// To find out, which substring is larger in terms of lexicography, I used compareTo() method on
// String obj.

package JavaSubstringComparisons;

public class JavaSubstringComparisons_v3 {
    public static String s = "welcometojava";

    public static void main(String[] args) {
        System.out.println(getSmallestAndLargest(s, 3));
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        for (int i = 0; i <= s.length() - k; i++) {
            String subStr = s.substring(i, i + k);
            if (smallest.length()==0) {
                smallest = subStr;
                largest = subStr;
            }
            if (smallest.compareTo(subStr)>0) smallest = subStr;
            if (largest.compareTo(subStr)<0) largest = subStr;
        }
        return smallest + "\n" + largest;
    }
}
