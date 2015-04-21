package ru.smalex.algo2015.sorting;

/**
 * Created by smalex on 21/04/15.
 */
public class MergeSort {
  public static void sort(Comparable[] a) {
    Comparable[] aux = new Comparable[a.length];
    sort(a, aux, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
    if (lo >= hi) {
      return;
    }
    if (lo + 1 == hi) {
      InsertionSort.sort(a, lo, hi);
      return;
    }
    int mid = lo + (hi - lo) / 2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid + 1, hi);
    merge(a, aux, lo, mid, hi);
    assert Utils.isSorted(a, lo, hi + 1);
  }

  private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
    assert Utils.isSorted(a, lo, mid);
    assert Utils.isSorted(a, mid + 1, hi);
    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }
    int i = lo;
    int j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > hi) {
        a[k] = aux[i++];
      } else if (Utils.less(aux[i], aux[j])) {
        a[k] = aux[i++];
      } else {
        a[k] = aux[j++];
      }
    }
    assert Utils.isSorted(a, lo, hi);
  }
}
