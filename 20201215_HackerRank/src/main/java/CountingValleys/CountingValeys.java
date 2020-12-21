//https://www.hackerrank.com/challenges/counting-valleys/problem

package CountingValleys;

public class CountingValeys {
    public static void main(String[] args) {
        int result = countingValleys(8, "DDUUUUDD");
        System.out.println(result);

    }

    public static int countingValleys(int steps, String path) {
        int valleyCounter = 0;
        int seaLevel = 0;
        int previousSeaLevel;
        char c;

        for (int i = 0; i < steps; i++) {
            c = path.charAt(i);
            previousSeaLevel = seaLevel;
            seaLevel = c == 'U' ? seaLevel + 1 : seaLevel - 1;
            if (previousSeaLevel==0 && seaLevel==-1) valleyCounter++;
        }
        return valleyCounter;
    }
}
