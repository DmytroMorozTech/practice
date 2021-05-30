package BillDivision;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'bonAppetit' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY // bill items
     *  2. INTEGER k // an integer representing the zero-based index of the item Anna doesn't eat
     *  3. INTEGER b // the amount of money that Anna contributed to the bill
     */

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        bill.set(k,0);
        Integer actualPayment = bill.stream().reduce((item, acc) -> acc + item).get()/2;
        int amountToBeReturned = b - actualPayment;
        if (amountToBeReturned == 0) {
            System.out.println("Bon Appetit");
            return;
        }

        System.out.println(amountToBeReturned);
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        Result.bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}
