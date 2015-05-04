package ru.smalex.algo2015.datastructures;

import ru.smalex.algo2015.util.Utils;

/**
 * Created by smalex on 04/05/15.
 */
public class BinarySearchTreeTest {
  public static void main(String[] args) {
    final BinarySearchTree<String, Integer> tree = new BinarySearchTree<String, Integer>();
    String[] keys = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
    Integer[] values = new Integer[]{1, 4, 8, 16, 32, 64, 128, 256};
    int[] indexes = new int[keys.length * 3];
    for (int i = 0; i < indexes.length; i++) {
      indexes[i] = i / 3;
    }
    Utils.shuffle(indexes);
    int size = 0;
    for (int index : indexes) {
      final String key = keys[index];
      boolean newElement = tree.contains(key);
      tree.put(key, values[index]);
      if (newElement) {
        size++;
      }
      assert tree.size() == size;
    }
    for (String key : keys) {
      System.out.println("tree[" + key + "] = " + tree.get(key));
    }
    assert tree.size() == keys.length;
  }
}
