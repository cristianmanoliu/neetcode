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

    assertFalse(wordDictionary.search("pad"));
    assertTrue(wordDictionary.search("bad"));
    assertTrue(wordDictionary.search(".ad"));
    assertTrue(wordDictionary.search("b.."));
  }

}