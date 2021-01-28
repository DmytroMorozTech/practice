// https://www.hackerrank.com/challenges/java-anagrams/problem

package JavaAnagrams;

public class JavaAnagramsBasic {
    public static void main(String[] args) {
        boolean res1Bool = isAnagram("aaabcde", "BaCadea");
        System.out.println("Checking strings 'aaabcde' and 'BaCadea':");
        String res1Str = res1Bool ? "Anagrams" : "Not anagrams";
        System.out.println(res1Str);

        boolean res2Bool = isAnagram("Super", "puRse");
        String res2Str = res2Bool ? "Anagrams" : "Not anagrams";
        System.out.println("Checking strings 'Super' and 'puRse':");
        System.out.println(res2Str);

        boolean res3Bool = isAnagram("super", "MyPurse");
        String res3Str = res3Bool ? "Anagrams" : "Not anagrams";
        System.out.println("Checking strings 'super' and 'MyPurse':");
        System.out.println(res3Str);
    }

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        a = a.toLowerCase();
        b = b.toLowerCase();
        int sum = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == c) {
                    sum++;
                }
                if (b.charAt(i) == c) {
                    sum--;
                }
            }
            if (sum != 0) {
                return false;
            }
        }
        return true;
    }
}
