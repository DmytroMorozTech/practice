package com.dima;

import java.util.Stack;

public class StringReverser {
    public static String reverse(String input) {
        if (input == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < input.length(); i++) {
//            stack.push(input.charAt(i));
//        }
//      a much cleaner solution goes below
        for (char ch : input.toCharArray())
            stack.push(ch);

        StringBuffer reversed = new StringBuffer();
        while (!stack.empty())
            reversed.append(stack.pop());
        return reversed.toString();
    }

    public static void main(String[] args) {
        String str = "abcdefghijklmnopQ";
        System.out.println(reverse(str));

    }

}
