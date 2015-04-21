package ru.smalex.algo2015.sorting;

/**
 * Created by smalex on 21/04/15.
 */
public class ShellSort {
  public static void sort(Comparable[] a) {
//    Utils.dump("unsorted", a);

    final int N = a.length;
    int h = 1;
    while (h < N/3) {
      h = h * 3 + 1;
    }
    while (h >= 1) {
      for (int i = h; i < N; i++) {
        for (int j = i; j >= h && Utils.less(a[j], a[j - h]); j -= h) {
          Utils.swap(a, j, j - h);
        }
      }
      h /= 3;
    }
//    Utils.dump("sorted", a);

    assert Utils.isSorted(a);
  }
}
