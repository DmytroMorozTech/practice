package JavaDeque;

import java.util.*;

// This is a time-efficient solution
public class SolutionV3_Optimal {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> ints = new ArrayList<>(Arrays.asList(5, 3, 5, 2, 3, 2));
        int n = ints.size(); // N of numbers in array
        int m = 3; // the size of subarray
        int max = Integer.MIN_VALUE;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int current = ints.get(i);
            deque.add(current);
            set.add(current);

            if (deque.size() == m) {
                max = Math.max(max, set.size());

                int firstElem = deque.remove();
                if (!deque.contains(firstElem))
                    set.remove(firstElem);
            }
        }

        System.out.println(max);
    }

}
