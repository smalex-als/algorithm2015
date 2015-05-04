package ru.smalex.algo2015.sorting;

import ru.smalex.algo2015.util.Utils;

/**
 * Created by smalex on 29/04/15.
 */
public class HeapSort {
  public static void sort(Comparable[] a) {
    int N = a.length;
    if (N < 2) {
      return;
    }
    for (int k = N / 2; k >= 0; k--) {
      sink(a, k, N);
    }
    while (N > 1) {
      exch(a, 0, --N);
      sink(a, 0, N);
    }
    assert Utils.isSorted(a);
  }

  public static void sink(Comparable[] a, int k, int N) {
    while (k * 2 + 1 < N) {
      int j = k * 2 + 1;
      if (j + 1 < N && less(a, j, j + 1)) j++;
      if (!less(a, k, j)) break;
      exch(a, k, j);
      k = j;
    }
  }

  private static void exch(Comparable[] a, int one, int two) {
    final Comparable tmp = a[one];
    a[one] = a[two];
    a[two] = tmp;
  }

  private static boolean less(Comparable[] a, int one, int two) {
    return a[one].compareTo(a[two]) < 0;
  }
}
