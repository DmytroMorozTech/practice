package JavaStack; //https://www.hackerrank.com/challenges/java-stack/

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static HashMap<Character, Character> mapping = new HashMap<>();
    private static ArrayList<String> strings = new ArrayList<>();
    private static ArrayList<String> strings2 = new ArrayList<>();

    static {
        strings.addAll(Arrays.asList(
                "{}()", "[{()}]", "({()})", "{}(", "({)}", "[[", "}{"));

        strings2.addAll((Arrays.asList(
                "({}[])",
                "(({()})))",
                "({(){}()})()({(){}()})(){()}",
                "{}()))(()()({}}{}",
                "}}}}",
                "))))",
                "{{{",
                "(((",
                "[]{}(){()}((())){{{}}}{()()}{{}{}}",
                "[[]][][]",
                "}{",
                ")))"
        )));

        mapping.put('}', '{');
        mapping.put(']', '[');
        mapping.put(')', '(');
    }

    public static void main(String[] args) {
        for (String s : strings2) {
            System.out.println(isBalanced(s));
        }
    }

    public static boolean isBalanced(String s) {
        Stack<Character> openingStack = new Stack<>();

        // Create an empty List of character
        List<Character> chars =
                        s
                        // Converting String to IntStream
                        .chars()
                        // Convert IntStream to Stream<Character>
                        .mapToObj(e -> (char) e)
                        // Collect the elements as a List Of Characters
                        .collect(Collectors.toList());

        Set<Character> closingP = mapping.keySet(); // closing parenthesis
        Collection<Character> openingP = mapping.values(); // opening parenthesis
        for (Character c : chars) {
            if (openingP.contains(c))
                openingStack.push(c);

            if (closingP.contains(c)) {
                Character oppositeParenthesis = mapping.get(c);
                if (openingStack.isEmpty()) return false;
                if (!openingStack.peek().equals(oppositeParenthesis)) return false;

                openingStack.pop();
            }
        }

        return openingStack.empty();
    }


}
