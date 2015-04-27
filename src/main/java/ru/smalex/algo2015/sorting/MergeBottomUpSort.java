package ru.smalex.algo2015.sorting;

import ru.smalex.algo2015.util.Utils;

/**
 * Created by smalex on 27/04/15.
 */
public class MergeBottomUpSort {
  public static void sort(Comparable[] a) {
    Comparable[] aux = new Comparable[a.length];
    int N = a.length;
    for (int sz = 1; sz < N; sz = sz + sz) {
      for (int lo = sz; lo < N - sz; lo += sz + sz) {
        merge(a, aux, lo, lo + sz - 1, Math.min(N - 1, lo + sz + sz - 1));
      }
    }
  }

  public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
    System.arraycopy(a, lo, aux, lo, hi - lo + 1);
    int i = lo;
    int j = mid + 1;
    for (int k = lo; k < hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > hi) {
        a[k] = aux[i++];
      } else if (Utils.less(a[j], a[i])) {
        a[k] = aux[j++];
      } else {
        a[k] = aux[i++];
      }
    }
  }
}
