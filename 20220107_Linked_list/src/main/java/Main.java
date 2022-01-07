import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        System.out.println(list.indexOf(20)); // 1

        list.removeFirst();
        System.out.printf("Linked list contains Node with value %d : %b \n", 30, list.contains(30)); // true
        System.out.printf("Linked list contains Node with value %d : %b \n", 890, list.contains(890)); // false

        list.addFirst(1);
        // current state of LinkedList: 1 -> 20 -> 30
        System.out.println("Current state of the Linked List:");
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("Last element was removed using method removeLast():");
        list.removeLast();
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("Current size of the Linked List:");
        System.out.println(list.size()); // 2
        System.out.println("Let us remove 2 more elements from the Linked List:");
        list.removeLast();
        list.removeLast();

        System.out.println("Current size of the Linked List:");
        System.out.println(list.size());
        System.out.println("list.toArray()");
        System.out.println(Arrays.toString(list.toArray()));

    }
}
