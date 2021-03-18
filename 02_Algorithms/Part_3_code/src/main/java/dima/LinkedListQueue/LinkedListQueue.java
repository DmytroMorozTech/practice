package dima.LinkedListQueue;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedListQueue {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    public void enqueue(int item) {
        Node node = new Node(item);
        if (isEmpty())
            head = tail = node;
        else {
            tail.next = node;
            tail = node;
        }

        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        int value;
        if (head == tail) {
            value = head.value;
            head = tail = null;
        } else {
            value = head.value;
            Node second = head.next;
            head.next = null;
            head = second;
        }
        count--;

        return value;
    }


    public boolean isEmpty() {
        return head.next == null;
    } //ok  O(1)

    public String toString() {
        ArrayList<Integer> list = new ArrayList<>();
        Node current = head;

        while (current != null) {
            list.add(current.value);
            current = current.next;
        }

        return list.toString();
    }

}