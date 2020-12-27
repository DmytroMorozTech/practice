package JavaLoops_2;

import java.util.*;

class JavaLoops_2 {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String series = "";
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            series = getSeries(a, b, n);
            System.out.println(series);
        }
        in.close();
    }

    public static String getSeries(int a, int b, int n) {
        String s = "";
        int temp = a;
        for (int i = 0; i <= n - 1; i++) {
            temp += Math.pow(2, i) * b;
            s = s + String.valueOf(temp) + " ";
        }
        return s;
    }
}
