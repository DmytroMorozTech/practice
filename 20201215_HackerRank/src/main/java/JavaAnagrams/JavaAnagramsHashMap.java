// https://www.hackerrank.com/challenges/java-anagrams/problem

package JavaAnagrams;

import java.util.HashMap;
import java.util.Map;

public class JavaAnagramsHashMap {
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
        Map<Character, Integer> aHashMap = convertStrToHashmap(a);
        Map<Character, Integer> bHashMap = convertStrToHashmap(b);
//        System.out.println(aHashMap);
//        System.out.println(bHashMap);
        return aHashMap.equals(bHashMap);
    }

    static Map<Character, Integer> convertStrToHashmap(String s) {
        char[] charsFromStr = s.toLowerCase().toCharArray();
        Map<Character, Integer> strAsHashmap = new HashMap<>();

        for (char c : charsFromStr) {
            if (strAsHashmap.containsKey(c)) {
                int currentVal = strAsHashmap.get(c);
                strAsHashmap.put(c, currentVal + 1);
                continue;
            }
            strAsHashmap.put(c, 1);
        }
        return strAsHashmap;
    }
}
