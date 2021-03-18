package dima.BinarySearch;

public class BinarySearch {
//    public static boolean contains(int[] arr, int el) {
//        int up = arr.length - 1;
//        int down = 0;
//
//        if (el > arr[up] || el < arr[down]) return false;
//
//        System.out.println(up);
//        System.out.println(down);
//
//        while (down <= up) {
//            int middleIndex = (up + down) / 2;
//            if (arr[middleIndex] < el) {
//                down = middleIndex + 1;
//            } else if (arr[middleIndex] > el) {
//                up = middleIndex - 1;
//            } else if (arr[middleIndex] == el)
//                return true;
//        }
//
//        return false;
//    }

    // BINARY SEARCH: now let's implement contains method using recursion.
    public static boolean contains(int[] as, int x) {
        if (x < as[0]) return false;
        if (x > as[as.length - 1]) return false;
        int l = 0;
        int r = as.length - 1;
        return containsR(as, x, l, r);
    }

    public static boolean containsR(int[] as, int x, int l, int r) {
        int m = (l + r) / 2;
        if (x < as[m]) r = m - 1;
        else if (x > as[m]) l = m + 1;
        if (x == as[m]) return true;

        if (l == r) return false;
        return containsR(as, x, l, r);
    }
    
    // Alexey did it in another way! To study it.
}
