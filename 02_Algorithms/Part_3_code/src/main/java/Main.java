import com.codewithmosh.BubbleSort;
import com.codewithmosh.InsertionSort;
import com.codewithmosh.MergeSort;
import com.codewithmosh.SelectionSortDima;
import dima.LinkedList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Bubble sort
//        int[] numbers = {7, 3, 1, 4, 6, 2, 3, -33, 27, 1000, -444};
        var sorter = new BubbleSort();
//        sorter.sort(numbers);
//        System.out.println(Arrays.toString(numbers));
//
//        ------------------------------------------------
//        int[] numbers = {7, 3, 1, 4, 6, 2, 3, -33, 27, 1000, -444};
//        var sorter = new MergeSort();
//        sorter.sort(numbers);
//        System.out.println(Arrays.toString(numbers));
//
//        System.out.println(numbers.length / 2);
//
//        var converter = new ConvertDecimalToBinary();
//        System.out.println(converter.findBinaryValue(-134));
//
//
//        String binaryString = "1010";
//        int decimal = Integer.parseInt(binaryString, 2);
//        System.out.println("Easy way:");
//        System.out.println(decimal);
//        ---------------------------------------------------
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(0);
        ll.addFirst(-3);
        ll.addFirst(-111);
        ll.addLast(123);
        ll.removeFirst();
        ll.removeLast();

        System.out.println(ll.toString_hr());
        System.out.println(ll.contains(1));
        System.out.println(ll.indexOf(1));
        System.out.println(ll.contains(22));
        System.out.println(ll.size());

        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);

        var array = ll.toArray();
        System.out.println(Arrays.toString(array));

        System.out.println(ll.getKthFromTheEnd(-1));

//        ll.reverse();
//        var array2 = ll.toArray();
//        System.out.println(Arrays.toString(array2));

        ll.reverseMain();
        var array3 = ll.toArray();
        System.out.println(Arrays.toString(array3));
    }
}
