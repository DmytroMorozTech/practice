//https://www.hackerrank.com/challenges/java-list/problem
package JavaList;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JavaList {


    public static void main(String[] args) {
        ArrayList<Integer> intArr;
        try (Scanner sc = new Scanner(System.in)) {
//            System.out.println("Please enter the length of array:");
            int lengthOfArr = Integer.parseInt(sc.nextLine());
//            System.out.println("Please enter the contents of array:");
            String arrayAsStr = sc.nextLine();

            intArr = new ArrayList<>(lengthOfArr);
            for (String s : arrayAsStr.split(" ")) {
                intArr.add(Integer.valueOf(s));
            }

            int numbOfQueries = Integer.parseInt(sc.nextLine());
            while (numbOfQueries > 0) {
                String op = sc.nextLine();
                if (op.equals("Insert")) {
                    String[] data = sc.nextLine().split(" ");
                    int index = Integer.parseInt(data[0]);
                    int value = Integer.parseInt(data[1]);
                    intArr.add(index, value);
                } else if (op.equals("Delete")) {
                    int index = Integer.parseInt(sc.nextLine());
                    intArr.remove(index);
                }

                numbOfQueries--;
            }
        }

        String result = intArr.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(result);
    }

}
