package io.github.cristianmanoliu.trie;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DesignAddAndSearchWordDataStructureTest {

  @Test
  void testAddAndSearchWord() {
    DesignAddAndSearchWordDataStructure wordDictionary = new DesignAddAndSearchWordDataStructure();

    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");

    assertFalse(wordDictionary.search("pad")); // false
    assertTrue(wordDictionary.search("bad"));  // true
    assertTrue(wordDictionary.search(".ad"));  // true
    assertTrue(wordDictionary.search("b.."));  // true
  }
}
