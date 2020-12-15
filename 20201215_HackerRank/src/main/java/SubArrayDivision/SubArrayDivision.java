//https://www.hackerrank.com/challenges/the-birthday-bar/problem

package SubArrayDivision;

import java.util.ArrayList;
import java.util.List;

public class SubArrayDivision {
    static List<Integer> inputList = new ArrayList<Integer>() {{
        add(2);
        add(2);
        add(1);
        add(3);
        add(2);
    }};

    public static void main(String[] args) {
        int result = birthday(inputList, 4, 2);
        System.out.printf("Result: %d ", result);
    }

    static int birthday(List<Integer> s, int d, int m) {
        int counter = 0;
        int tempResult;

        for (int i = 0; i <= s.size() - m; i++) {
            tempResult = 0;
            for (int j = i; j < i + m; j++) {
                tempResult += s.get(j);
            }
            counter = tempResult == d ? counter + 1 : counter;
        }
        return counter;
    }
}
