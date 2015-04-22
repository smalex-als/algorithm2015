package ru.smalex.algo2015.sorting;

import ru.smalex.algo2015.util.Utils;

/**
 * Created by smalex on 22/04/15.
 */
public class QuickSort {
  public static void sort(Comparable[] a) {
    sort(a, 0, a.length - 1);
    assert Utils.isSorted(a);
  }

  private static void sort(Comparable[] a, int lo, int hi) {
    if (lo >= hi) {
      return;
    }
    if (hi - lo < 15) {
      InsertionSort.sort(a, lo, hi);
      return;
    }
    int j = partition(a, lo, hi);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
  }

  private static int partition(Comparable[] a, int lo, int hi) {
    int i = lo;
    int j = hi + 1;
    Comparable v = a[lo];
    while (true) {
      while (Utils.less(a[++i], v)) {
        if (i == hi) break;
      }
      while (Utils.less(v, a[--j])) {
        if (j == lo) break;
      }
      if (i >= j) {
        break;
      }
      Utils.swap(a, i, j);
    }
    Utils.swap(a, lo, j);
    return j;
  }

  public static void sort(int[] a) {
    sort(a, 0, a.length - 1);
    assert Utils.isSorted(a);
  }

  private static void sort(int[] a, int lo, int hi) {
    if (lo >= hi) {
      return;
    }
    if (hi - lo < 15) {
      InsertionSort.sort(a, lo, hi);
      return;
    }
    int j = partition(a, lo, hi);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
  }

  private static int partition(int[] a, int lo, int hi) {
    int i = lo;
    int j = hi + 1;
    int v = a[lo];
    while (true) {
      while (a[++i] < v) {
        if (i == hi) break;
      }
      while (v < a[--j]) {
        if (j == lo) break;
      }
      if (i >= j) {
        break;
      }
      Utils.swap(a, i, j);
    }
    Utils.swap(a, lo, j);
    return j;
  }

}
