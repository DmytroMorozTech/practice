package com.codewithmosh;

public class Main {
    public static void main(String[] names) {
//        var s = new Search();
//        int[] n = { 1 };
//        System.out.println(s.binarySearchRec(n, 1));

        var tree = new AVLTreeDima();
        tree.insert(10);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        tree.insert(90);
        tree.insert(11);
        tree.insert(12);
        tree.insert(11);
        tree.insert(1111);
        tree.insert(2222);
        tree.insert(222222);
        System.out.println(tree.isBalanced());
    }
}

