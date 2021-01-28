package JavaStringReverse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JavaStringReverse {
    public static void main(String[] args) {
        System.out.println(getIsPalindrome("madam"));
    }

    public static String getIsPalindrome(String s) {
        List<String> listStr = new ArrayList<>(Arrays.asList(s.split("")));
        Collections.reverse(listStr);
        String reversedStr = String.join("", listStr);
        System.out.println(listStr);
        System.out.println(reversedStr);
        return s.equals(reversedStr) ? "Yes" : "No";
    }
}
