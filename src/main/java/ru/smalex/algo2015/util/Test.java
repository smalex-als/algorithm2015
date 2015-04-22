package ru.smalex.algo2015.util;

import ru.smalex.algo2015.sorting.InsertionSort;
import ru.smalex.algo2015.sorting.MergeSort;
import ru.smalex.algo2015.sorting.QuickSort;
import ru.smalex.algo2015.sorting.SelectionSort;
import ru.smalex.algo2015.sorting.ShellSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by smalex on 21/04/15.
 */
public class Test {
  public static final Sortable SELECTION_SORT = new Sortable() {
    public void sort(Comparable[] a) {
      SelectionSort.sort(a);
    }
  };
  public static final Sortable INSERTION_SORT = new Sortable() {
    public void sort(Comparable[] a) {
      InsertionSort.sort(a);
    }
  };
  public static final Sortable SHELL_SORT = new Sortable() {
    public void sort(Comparable[] a) {
      ShellSort.sort(a);
    }
  };
  public static final Sortable MERGE_SORT = new Sortable() {
    public void sort(Comparable[] a) {
      MergeSort.sort(a);
    }
  };
  public static final Sortable QUICK_SORT = new Sortable() {
    public void sort(Comparable[] a) {
      QuickSort.sort(a);
    }
  };

  public static void main(String[] args) {
    sortObjects();
  }

  private static void sortObjects() {
    List<Sortable> sortables = new ArrayList<Sortable>();
    sortables.add(SELECTION_SORT);
    sortables.add(INSERTION_SORT);
    sortables.add(SHELL_SORT);
    sortables.add(MERGE_SORT);
    sortables.add(QUICK_SORT);

    Integer[] orig = Utils.shuffleNumbers(16);
//    Utils.dump("unsorted", arrays);
    for (Sortable sortable : sortables) {
      Integer[] arrays = Arrays.copyOf(orig, orig.length);
      assert !Utils.isSorted(arrays);
      final long start = System.currentTimeMillis();
      sortable.sort(arrays);
      final long finish = System.currentTimeMillis();
      System.out.println(String.format("%.2f sec", (finish - start) / 1000.0f));
    }
//    Utils.dump("sorted", arrays);
  }
}
