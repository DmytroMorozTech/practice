package JavaStdinAndStdout_II;

import java.util.Scanner;

public class JavaStdinAndStdout_II {

    public static class Solution {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int i = scan.nextInt();
            scan.nextLine(); // Pay attention to that we should always consume the buffered
            // left-over (in this case it was "\n"). Read below for more.
            double d = scan.nextDouble();
            scan.nextLine();
            String s = scan.nextLine();

            System.out.println("String: " + s);
            System.out.println("Double: " + d);
            System.out.println("Int: " + i);
        }
    }
}

// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
// we may use this line of code as well. It is used at HackerRank web-site.

//            https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
//            That's because the Scanner.nextInt method does not read the newline character in your
//            input created by hitting "Enter," and so the call to Scanner.nextLine returns after
//            reading that newline.
//
//            You will encounter the similar behaviour when you use Scanner.nextLine after
//            Scanner.next() or any Scanner.nextFoo method (except nextLine itself).
//
//            Workaround:
//
//            Either put a Scanner.nextLine call after each Scanner.nextInt or Scanner.nextFoo
//             to consume rest of that line including newline
//
//            int option = input.nextInt();
//            input.nextLine();  // Consume newline left-over  !!!
//            String str1 = input.nextLine();
