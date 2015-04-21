package ru.smalex.algo2015.sorting;

import ru.smalex.algo2015.util.Utils;

/**
 * Created by smalex on 21/04/15.
 */
public class SelectionSort {
  public static void sort(Comparable[] a) {
    final int N = a.length;
    for (int i = 0; i < N; i++) {
      int min = i;
      for (int j = i + 1; j < N; j++) {
        if (Utils.less(a[j], a[min])) {
          min = j;
        }
      }
      Utils.swap(a, i, min);
    }
    assert Utils.isSorted(a);
  }
}
