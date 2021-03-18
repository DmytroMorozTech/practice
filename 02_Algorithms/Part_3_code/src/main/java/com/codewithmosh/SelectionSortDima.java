package com.codewithmosh;

public class SelectionSortDima {
    public void sort(int[] arr) {
        int minValue;
        for (int i = 0; i < arr.length; i++) {
            minValue = findMinValue(arr, i);
            int indexOfMinVal = indexOf(arr, minValue);
            arr[indexOfMinVal] = arr[i];
            arr[i] = minValue;
        }
    }

    public int findMinValue(int[] arr, int startIndex) {
        int minVal = Integer.MAX_VALUE;
        for (int i = startIndex; i < arr.length; i++) {
            if (arr[i] < minVal) minVal = arr[i];
        }
        return minVal;
    }

    public int indexOf(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == value) return i;
        return -1;
    }
}
