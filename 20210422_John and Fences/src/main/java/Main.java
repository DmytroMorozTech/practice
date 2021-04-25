import java.sql.Array;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<int[]> arr = new ArrayList<>();
        arr.add(new int[]{2, 5, 7, 4, 1, 8}); // 4*3 = 12
        arr.add(new int[]{2, 2, 3, 4, 5, 5}); // 4*3 = 12
        arr.add(new int[]{1, 2, 1, 2, 2, 2}); // 2*3 = 6
        arr.add(new int[]{3, 3, 3, 3, 8, 8}); // 8*2 = 16
        arr.add(new int[]{5, 5, 5, 5, 5, 2}); // 5*5 = 25
        arr.add(new int[]{8, 8, 8, 3, 9, 9}); // 3*8 = 24
        arr.forEach(array -> System.out.println(Arrays.toString(array)));

        arr.forEach(array -> System.out.println(getMaxSquareOfFence(array)));

    }

    /**
     * @param H -> int [] with heights of boards that constitute the fence.
     * @return int -> max area that can be formed by arbitrary number of sequential boards
     * in particular fence.
     */
    public static int getMaxSquareOfFence(int[] H) {
        Map<Integer, Map<Integer, Boolean>> areas = new HashMap<>();

        Map<Integer, Boolean> areaForBoard = new HashMap<>();
        // Integer - area for particular board height; Boolean - whether is is still sequential or not
        int previousElem = H[0];
        boolean sectionIsContinuous = true;

        for (int i = 0; i < H.length; i++) {
            int current = H[i];

            if (!areas.containsKey(current)) {
                Map<Integer, Boolean> secondLevelMap = new HashMap<>();
                secondLevelMap.put(current, true);
                areas.put(current, secondLevelMap);
            }

            sectionIsContinuous = previousElem <= current ? true : false;

            if (sectionIsContinuous && current != H[0]) {
                Integer currentValue = areas.get(current);
                areas.put(current, currentValue + current);
            }

            previousElem = current;
        }
        Integer res = areas.values().stream().max((a, b) -> a - b).get();
        return res;
    }


}
