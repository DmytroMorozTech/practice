package dima;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class LinkedList {
    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addLast(int item) {
        Node node = new Node(item);
        if (isEmpty()) first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int item) {
        Node node = new Node(item);
        if (isEmpty()) first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    private boolean isEmpty() {
        return first == null;
    }


    public void removeFirst() {
        if (isEmpty())
            throw new IllegalArgumentException();
        if (first == last)
            first = last = null;
        else {
            Node second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last)
            first = last = null;
        else {
            Node previous = getPrevious(last);
            last = previous;
            previous.next = null;
        }
        size--;
    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public int indexOf(int item) {
        var index = 0;
        var current = first;
        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index += 1;
        }
        return -1;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = first;
        int index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public StringJoiner toString_hr(Node curr, StringJoiner sj) {
        if (curr == null) return sj;
        return toString_hr(curr.next, sj.add(String.valueOf(curr.value)));
    }

    public String toString_hr() {
        StringJoiner sj = new StringJoiner(", ", "LL:[", "]");
        StringJoiner built = toString_hr(first, sj);
        return built.toString();
    }

    public int size() {
        return size;
    }


    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }

    public void reverse() {
        if (isEmpty()) return;
        var previous = first;
        var current = first.next;

        while (current != null) {
            var next = current.next;
            current.next = previous; // setting the link from the current to the previous node
            previous = current; // shift the pointer for previous one position to the right
            current = next;     // shift the pointer for current one position to the right
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromTheEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();

        var a = first;
        Node b = first;
        for (int i = 0; i < k - 1; i++) {
            b = b.next;
            if (b == null)
                throw new IllegalArgumentException();
        }
        while (b != last) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

//    ----------------------------------------
    public void reverseRecursive(Node previous, Node current) {
        if (current == null) {
            last = first;
            last.next = null;
            first = previous;
            return;
        }

        var next = current.next;
        current.next = previous;
        previous = current;
        current = next;
        reverseRecursive(previous,current);

    }

    public void reverseMain() {
        if (isEmpty()) return;
        reverseRecursive(first, first.next);
    }
    //    ----------------------------------------

}