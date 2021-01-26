// At first I thought that this solution was the right one. But It turned out, that I
// misunderstood the task. Here we're calculating the lexicographical "weight" (points) for all
// letters that form one substring.
// The largest and the smallest substrings were chosen based on this principle.
// It turned out, that in this task we should sort these substrings using String.compareTo() method.
// The thing is, that strings are to be compared sequentially: letter by letter.

// And the sum of points of ASCII codes of all letters in some particular substring is not
// decisive in this case. Please, see the final solution -> v3.

package JavaSubstringComparisons;

public class JavaSubstringComparisons_v2 {
    public static String s = "welcometojava";

    public static void main(String[] args) {
        System.out.println(getSmallestAndLargest(s, 3));
        System.out.println("-------------------------");
        System.out.printf("ava: %s\n", calcLexicalPoints("ava"));
        System.out.printf("wel: %s\n", calcLexicalPoints("wel"));
        System.out.println("--------------------------------------");
        System.out.printf("elc: %s\n", calcLexicalPoints("elc"));
        System.out.printf("toj: %s\n", calcLexicalPoints("toj"));
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        int minLexPoints = Integer.MAX_VALUE;
        int maxLexPoints = Integer.MIN_VALUE;

        for (int i = 0; i <= s.length() - k; i++) {
            String subStr = s.substring(i, i + k);
            int currentLexPoints = calcLexicalPoints(subStr);
//            System.out.println(currentLexPoints);
            if (currentLexPoints < minLexPoints) {
                smallest = subStr;
                minLexPoints = currentLexPoints;
//                System.out.printf("minLexPoints: %d\n", minLexPoints);
//                System.out.printf("Smallest: %s\n", smallest);
            }
            if (currentLexPoints > maxLexPoints) {
                largest = subStr;
                maxLexPoints = currentLexPoints;
//                System.out.printf("maxLexPoints: %d\n", maxLexPoints);
//                System.out.printf("Largest: %s\n", largest);
            }
        }

        return smallest + "\n" + largest;
    }

    public static int calcLexicalPoints(String s) {
        char[] charsArr = s.toCharArray();
        int lexPoints = 0;
        for (char ch : charsArr) {
            lexPoints += ch;
        }
        return lexPoints;
    }
}
