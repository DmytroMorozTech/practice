package app;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static int readNumber(String prompt, int min, int max) {
        String input;
        int value = Integer.MIN_VALUE;
        while (true) {
            System.out.println(prompt);
            input = scanner.nextLine();
            try {
                value = Integer.valueOf(input);
            } catch(NumberFormatException e) {
                System.out.println("You've entered the wrong data format!");
                value = Integer.MIN_VALUE;
            }
            if (value >= min && value <= max)
                break;
            System.out.println("Enter an integer value between " + min + " and " + max);
        }
        return value;
    }
}
