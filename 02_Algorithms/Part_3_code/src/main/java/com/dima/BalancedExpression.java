package com.dima;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class BalancedExpression {
    //this is my solution

    public static void main(String[] args) {
        String str = "((<>[]{}))";
        String str2 = "[<[()()()()][{}][{}<><>]{}[]()()slkjdfhksjdhfksjdhfj()()[]<>>]";
        String str3 = ")(";
        boolean strIsBalanced = checkStringForBalance(str2);
        System.out.println(strIsBalanced);
    }

    private static boolean checkStringForBalance(String str) {
        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put('[', ']');
        brackets.put('(', ')');
        brackets.put('{', '}');
        brackets.put('<', '>');

        ArrayList<Character> closingBrackets =
                new ArrayList<Character>(Arrays.asList(')', '>', ']', '}'));

        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {

            if (closingBrackets.contains(ch) && stack.isEmpty()) return false;

            if (closingBrackets.contains(ch)) {
                Character lastElemInStack = stack.pop();
                if (!brackets.get(lastElemInStack).equals(ch))
                    return false;
            }

            if (brackets.containsKey(ch))
                stack.push(ch);
        }
        return stack.empty();
    }

}
