//https://www.hackerrank.com/challenges/cats-and-a-mouse/problem

package CatsAndMouse;

public class CatsAndMouse {
    public static void main(String[] args) {
        System.out.println(catAndMouse(1, 2, 3));
        System.out.println(catAndMouse(1, 3, 2));
    }

    static String catAndMouse(int x, int y, int z) {
        int deltaX = Math.abs(x - z);
        int deltaY = Math.abs(y - z);
        int diff = deltaX - deltaY;
        return diff > 0 ? "Cat B" : diff < 0 ? "Cat A" : "Mouse C";
    }
}
