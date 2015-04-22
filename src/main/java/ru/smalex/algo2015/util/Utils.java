package ru.smalex.algo2015.util;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by smalex on 21/04/15.
 */
public class Utils {
  public static boolean less(Comparable a, Comparable b) {
    return a.compareTo(b) < 0;
  }

  public static void swap(Comparable[] a, int i, int j) {
    if (i == j) {
      return;
    }
    final Comparable tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }

  public static void swap(int[] a, int i, int j) {
    if (i == j) {
      return;
    }
    final int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }

  public static boolean isSorted(Comparable[] a) {
    return isSorted(a, 0, a.length - 1);
  }

  public static boolean isSorted(int[] a) {
    return isSorted(a, 0, a.length - 1);
  }

  public static boolean isSorted(Comparable[] a, int low, int hi) {
    for (int i = low + 1; i < hi; i++) {
      if (less(a[i], a[i - 1])) {
        return false;
      }
    }
    return true;
  }

  public static boolean isSorted(int[] a, int low, int hi) {
    for (int i = low + 1; i < hi; i++) {
      if (a[i] < a[i - 1]) {
        return false;
      }
    }
    return true;
  }

  public static Integer[] shuffleNumbers(int n) {
    Integer[] arrays = new Integer[n];
    Random random = new Random();
    for (int i = 0; i < arrays.length; i++) {
      arrays[i] = Math.abs(random.nextInt() % arrays.length);
    }
    return arrays;
  }
  public static int[] shuffleNumbersInt(int n) {
    int[] arrays = new int[n];
    Random random = new Random();
    for (int i = 0; i < arrays.length; i++) {
      arrays[i] = Math.abs(random.nextInt() % arrays.length);
    }
    return arrays;
  }

  public static void dump(String name, Object[] arrays) {
    System.out.println(name + " = " + Arrays.toString(arrays));
  }
}
