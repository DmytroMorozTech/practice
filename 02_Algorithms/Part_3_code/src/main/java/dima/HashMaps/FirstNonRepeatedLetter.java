package dima.HashMaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeatedLetter {

    public char findLetter(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            int count = map.containsKey(c) ? map.get(c) : 0;
            map.put(c, count + 1);
        }
        System.out.println(map);

        for (char c : chars) {
            if (map.get(c) == 1) return c;
        }
        return Character.MIN_VALUE;
    }

    public char findFirstRepeatedChar(String str) {
        Set<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (set.contains(ch)) return ch;

            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
