package com.codewithmosh;

public class MergeSort {
  public void sort(int[] array) {
    if (array.length < 2)
      return;

    var middle = array.length / 2;

    int[] left = new int[middle];
    for (var i = 0; i < middle; i++)
      left[i] = array[i];

    int[] right = new int[array.length - middle];
    for (var i = middle; i < array.length; i++)
      right[i - middle] = array[i];
    // this expression: [i - middle] allows us to calcultate the right index of element in new array.

    sort(left);
    sort(right);

    merge(left, right, array);
  }

  private void merge(int[] left, int[] right, int[] result) {
    int i = 0, j = 0, k = 0;

    while (i < left.length && j < right.length) {
      if (left[i] <= right[j])
        result[k++] = left[i++];
      else
        result[k++] = right[j++];
    }

    while (i < left.length)
      result[k++] = left[i++];

    while (j < right.length)
      result[k++] = right[j++];
  }

  private void merge2(int[] a, int[] b, int[] c) {
    int ai = 0, bi = 0, ci = 0;

    while (ai < a.length && bi < b.length) {
      if (a[ai] <= b[bi])
        c[ci++] = a[ai++];
      else
        c[ci++] = b[bi++];
    }

    while (ai < a.length)
      c[ci++] = a[ai++];

    while (bi < b.length)
      c[ci++] = b[bi++];
  }
}
