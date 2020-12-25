// https://www.hackerrank.com/challenges/apple-and-orange/problem

package ApplesAndOranges;

public class ApplesAndOranges {
    static int[] arr1 = {-2, 2, 1};
    static int[] arr2 = {5, -6};
    static int numbOfApples = 0;
    static int numbOfOranges = 0;

    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        for (int apple : apples) {
            numbOfApples = ((a + apple) >= s && (a + apple) <= t) ? numbOfApples + 1 : numbOfApples;
        }

        for (int orange : oranges) {
            numbOfOranges = ((b + orange) >= s && (b + orange) <= t) ? numbOfOranges + 1 : numbOfOranges;
        }

        System.out.println(numbOfApples);
        System.out.println(numbOfOranges);
    }


    public static void main(String[] args) {
        countApplesAndOranges(7, 11, 5, 15, arr1, arr2);
    }
}
