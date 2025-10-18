package io.github.cristianmanoliu.trie;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PrefixTreeTest {

  @Test
  public void testPrefixTree() {
    PrefixTree prefixTree = new PrefixTree();

    prefixTree.insert("apple");
    assertTrue(prefixTree.search("apple"));   // returns true
    assertFalse(prefixTree.search("app"));     // returns false
    assertTrue(prefixTree.startsWith("app")); // returns true

    prefixTree.insert("app");
    assertTrue(prefixTree.search("app"));     // returns true
  }

}