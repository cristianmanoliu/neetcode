package io.github.cristianmanoliu.linked_list;

import java.util.HashMap;
import java.util.Map;

// https://neetcode.io/problems/lru-cache?list=neetcode150
// https://leetcode.com/problems/lru-cache
public class LRUCache {

  private final int capacity;
  private final Map<Integer, Node> map;
  private final Node head; // dummy head (MRU side)
  private final Node tail; // dummy tail (LRU side)

  public LRUCache(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("Capacity must be positive");
    }
    this.capacity = capacity;
    this.map = new HashMap<>(capacity * 2);
    this.head = new Node(-1, -1);
    this.tail = new Node(-1, -1);
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    Node node = map.get(key);
    if (node == null) {
      return -1;
    }
    moveToFront(node);
    return node.value;
  }

  public void put(int key, int value) {
    Node node = map.get(key);
    if (node != null) {
      node.value = value;
      moveToFront(node);
      return;
    }
    // insert new node at front
    Node fresh = new Node(key, value);
    map.put(key, fresh);
    addAfterHead(fresh);

    // evict if over capacity
    if (map.size() > capacity) {
      Node lru = removeLRU();
      map.remove(lru.key);
    }
  }

  // ==== Doubly-linked list helpers ====
  private void moveToFront(Node node) {
    // detach
    node.prev.next = node.next;
    node.next.prev = node.prev;
    // add after head
    addAfterHead(node);
  }

  private void addAfterHead(Node node) {
    node.next = head.next;
    node.prev = head;
    head.next.prev = node;
    head.next = node;
  }

  private Node removeLRU() {
    Node lru = tail.prev;
    // unlink lru
    lru.prev.next = tail;
    tail.prev = lru.prev;
    lru.prev = lru.next = null;
    return lru;
  }

  private static class Node {

    int key, value;
    Node prev, next;

    Node(int k, int v) {
      key = k;
      value = v;
    }
  }
}
