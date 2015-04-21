package ru.smalex.algo2015.sorting;

import ru.smalex.algo2015.util.Utils;

/**
 * Created by smalex on 21/04/15.
 */
public class InsertionSort {
  public static void sort(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      for (int j = i; j > 0 && Utils.less(a[j], a[j - 1]); j--) {
        Utils.swap(a, j, j - 1);
      }
    }
    assert Utils.isSorted(a);
  }

  public static void sort(Comparable[] a, int lo, int hi) {
    for (int i = lo + 1; i <= hi; i++) {
      for (int j = i; j > lo && Utils.less(a[j], a[j - 1]); j--) {
        Utils.swap(a, j, j - 1);
      }
    }
  }
}
