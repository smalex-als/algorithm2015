package ru.smalex.algo2015.datastructures;

/**
 * Created by smalex on 04/05/15.
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
  private Node root;

  private class Node {
    private Key key;
    private Value value;
    private Node left;
    private Node right;
    private int N;

    public Node(Key key, Value value, int n) {
      this.key = key;
      this.value = value;
      N = n;
    }
  }

  public boolean contains(Key key) {
    return get(key) != null;
  }

  public Value get(Key key) {
    return get(root, key);
  }

  private Value get(Node node, Key key) {
    if (node == null) {
      return null;
    }
    final int cmp = key.compareTo(node.key);
    if (cmp < 0) return get(node.left, key);
    if (cmp > 0) return get(node.right, key);
    return node.value;
  }

  public int size() {
    return size(root);
  }

  private int size(Node root) {
    return root == null ? 0 : root.N;
  }

  public void put(Key key, Value value) {
    root = put(root, key, value);
  }

  private Node put(Node node, Key key, Value value) {
    if (node == null) {
      return new Node(key, value, 1);
    }
    final int cmp = key.compareTo(node.key);
    if (cmp < 0) {
      node.left = put(node.left, key, value);
    } else if (cmp > 0) {
      node.right = put(node.right, key, value);
    } else {
      node.value = value;
    }
    node.N = 1 + size(node.left) + size(node.right);
    return node;
  }
}
