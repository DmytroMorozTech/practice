package com.dima.PrintMiddle;

import com.dima.LinkedList;
import com.dima.LinkedList.Node;

public class PrintMiddle {
    public static String print(LinkedList ll) {
        Node a = ll.getFirst();
        Node b = ll.getFirst();

        while (b != ll.getLast() && b.getNext() != ll.getLast()) {
            b = b.getNext().getNext();
            a = a.getNext();
        }

        if (b == ll.getLast())
            return String.valueOf(a.getValue());
        else
            return String.valueOf(a.getValue() + ", " + a.getNext().getValue());
    }
}
