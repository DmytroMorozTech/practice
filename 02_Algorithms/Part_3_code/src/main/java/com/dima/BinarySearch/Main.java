package com.dima.BinarySearch;

public class Main {
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] initialArr = {1, 3, 6, 8, 9, 12, 13, 16, 18, 22, 100, 200, 210, 300};
        System.out.println(BinarySearch.contains(initialArr, 215));
    }
}
