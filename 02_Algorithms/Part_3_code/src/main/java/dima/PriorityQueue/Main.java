package dima.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.add(5);
        queue.add(3);
        queue.add(6);
        queue.add(1);
        queue.add(4);
        System.out.println(queue);

        while (!queue.isEmpty())
            System.out.println(queue.remove());
    }
}
