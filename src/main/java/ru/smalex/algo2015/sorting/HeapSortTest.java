package ru.smalex.algo2015.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by smalex on 29/04/15.
 */
public class HeapSortTest {
  @Test
  public void testSink() {
    Integer[] a = new Integer[]{4, 4, 3, 1, 2};
    HeapSort.sink(a, 0, a.length);
    Assert.assertArrayEquals(new Integer[]{4, 4, 3, 1, 2}, a);
    HeapSort.sink(a, 2, a.length);
    Assert.assertArrayEquals(new Integer[]{4, 4, 3, 1, 2}, a);
    HeapSort.sink(a, 1, a.length);
    Assert.assertArrayEquals(new Integer[]{4, 4, 3, 1, 2}, a);
  }

  @Test
  public void testTwo() {
    Integer[] a = new Integer[]{1, 2};
    HeapSort.sink(a, 0, a.length);
    Assert.assertArrayEquals(new Integer[]{2, 1}, a);
  }
}
