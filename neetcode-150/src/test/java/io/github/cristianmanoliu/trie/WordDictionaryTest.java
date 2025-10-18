package io.github.cristianmanoliu.trie;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WordDictionaryTest {

  @Test
  public void testWordDictionary() {
    WordDictionary wordDictionary = new WordDictionary();

    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");

    assertFalse(wordDictionary.search("pad")); // returns false
    assertTrue(wordDictionary.search("bad"));   // returns true
    assertTrue(wordDictionary.search(".ad"));   // returns true
    assertTrue(wordDictionary.search("b.."));   // returns true
  }

}