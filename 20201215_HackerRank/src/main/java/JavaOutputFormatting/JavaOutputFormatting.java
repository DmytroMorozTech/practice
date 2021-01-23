//https://www.hackerrank.com/challenges/java-output-formatting/problem
package JavaOutputFormatting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaOutputFormatting {
    private static List<String> inputStrings = new ArrayList<>();

    public static void main(String[] args) {
        Collections.addAll(inputStrings, "java 100", "cpp 65", "python 50");
        System.out.println("================================");

        for (String s : inputStrings) {
            String text = s.split(" ")[0];
            int x = Integer.parseInt(s.split(" ")[1]);
            String whiteSpaces = getNumbOfWhiteSpaces(text);
            String xAsString = convertIntToStr(x);
            System.out.printf("%s%s%s\n", text,whiteSpaces,xAsString);
        }
        System.out.println("================================");
    }

    public static String getNumbOfWhiteSpaces(String text) {
        int numbOfWhiteSpaces = 14 - text.length();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i <= numbOfWhiteSpaces; i++) {
            str.append(" ");
        }
        return str.toString();
    }

    public static String convertIntToStr(int numb) {
        String numbAsStr = String.valueOf(numb);
        if (numbAsStr.length()==3) return numbAsStr;
        return numbAsStr.length()==1 ? "00" + numbAsStr : "0" + numbAsStr;
    }
}
