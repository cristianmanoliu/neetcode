package io.github.cristianmanoliu.linked_list;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LRUCacheTest {

  @Test
  public void testLRUCache() {
    LRUCache lruCache = new LRUCache(2);

    lruCache.put(1, 1);
    lruCache.put(2, 2);
    assertEquals(1, lruCache.get(1)); // returns 1

    lruCache.put(3, 3); // evicts key 2
    assertEquals(-1, lruCache.get(2)); // returns -1 (not found)

    lruCache.put(4, 4); // evicts key 1
    assertEquals(-1, lruCache.get(1)); // returns -1 (not found)
    assertEquals(3, lruCache.get(3)); // returns 3
    assertEquals(4, lruCache.get(4)); // returns 4
  }

}