//https://www.hackerrank.com/challenges/kangaroo/problem?h_r=next-challenge&h_v=zen&isFullScreen=false

package NumberLineJumps;

public class NumberLineJumps {

    public static void main(String[] args) {
        String result = kangaroo(0, 3, 4, 2);
        System.out.println(result);
    }
//    x1, v1: integers, starting position and jump distance for kangaroo 1
//    x2, v2: integers, starting position and jump distance for kangaroo 2

    static String kangaroo(int x1, int v1, int x2, int v2) {
        if (v2 > v1) return "NO";

        while (x2 > x1) {
            x1 = x1 + v1;
            x2 = x2 + v2;
            if (x1 == x2) return "YES";
        }
        return "NO";
    }
}
