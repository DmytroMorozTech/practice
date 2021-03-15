//https://www.hackerrank.com/challenges/pattern-syntax-checker/problem
package PatternSyntaxChecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class PatternSyntaxChecker {
    static List<String> sampleInputs = new ArrayList<>(Arrays.asList(
            "([A-Z])(.+)", "[AZ[a-z](a-z)", "batcatpat(nat"
    ));

    public static void main(String[] args) {
        for (String s : sampleInputs) {
            try {
                Pattern.compile(s);
                System.out.println("Valid");
            } catch (Exception e) {
                System.out.println("Invalid");
            }
        }
    }
}


// Original solution from HackerRank
//import java.util.Scanner;
//import java.util.regex.*;
//
//public class Solution
//{
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int testCases = Integer.parseInt(in.nextLine());
//        while(testCases>0){
//            String pattern = in.nextLine();
//            try {
//                Pattern.compile(pattern);
//                System.out.println("Valid");
//            } catch (Exception e) {
//                System.out.println("Invalid");
//            }
//            testCases = testCases -1;
//        }
//    }
//}

