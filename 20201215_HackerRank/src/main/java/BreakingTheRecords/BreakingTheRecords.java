// https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem

package BreakingTheRecords;

import java.util.Arrays;

public class BreakingTheRecords {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 20, 20, 4, 5, 2, 25, 1};
        int[] result;
        result = breakingRecords(arr);
        System.out.println(Arrays.toString(result));
    }

    static int[] breakingRecords(int[] scores) {
        int[] result = new int[2];
        int maxElem = scores[0], minElem = scores[0], maxCounter = 0, minCounter = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < minElem) {
                minElem = scores[i];
                minCounter++;
            }
            if (scores[i] > maxElem) {
                maxElem = scores[i];
                maxCounter++;
            }
        }
        result[0] = maxCounter;
        result[1] = minCounter;
        return result;
    }
}
