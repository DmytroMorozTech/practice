package JavaDeque;

import java.util.*;

public class SolutionV2 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> ints = new ArrayList<>(Arrays.asList(5, 3, 5, 2, 3, 2));
        int n = ints.size(); // N of numbers in array
        int m = 3; // the size of subarray
        int max = Integer.MIN_VALUE;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int current = ints.get(i);
            deque.addLast(current);

            if (deque.size() == m) {
                System.out.println(deque);
                addDequeElemsToSet(deque, set);
                max = Math.max(max, set.size());

                deque.removeFirst();
            }
        }

        System.out.println(max);
    }

    private static void addDequeElemsToSet(Deque<Integer> deque, Set<Integer> set) {
        set.clear();
        for (Integer dequeElem : deque) {
            set.add(dequeElem);
        }
    }
    // this solution does work, bu it is not time-efficient


}
