package CompareTheTriplets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareTheTriplets {
    static List<Integer> a = new ArrayList<>();
    static List<Integer> b = new ArrayList<>();

    public static void main(String[] args) {
        Collections.addAll(a, 17, 28, 30);
        Collections.addAll(b, 19, 16, 8);

        System.out.println(compareTriplets(a, b));
    }

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aCount = 0;
        int bCount = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            aCount = a.get(i) > b.get(i) ? aCount + 1 : aCount;
            bCount = b.get(i) > a.get(i) ? bCount + 1 : bCount;
        }
        Collections.addAll(result, aCount, bCount);
        return result;
    }
}
