package io.github.cristianmanoliu.trie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit 5 tests for WordSearchII
class WordSearchIITest {

  private List<String> sorted(List<String> in) {
    List<String> copy = new ArrayList<>(in);
    Collections.sort(copy);
    return copy;
  }

  @Test
  @DisplayName("LeetCode example: typical board with multiple hits")
  void example1() {
    WordSearchII sol = new WordSearchII();
    char[][] board = {
        {'o', 'a', 'a', 'n'},
        {'e', 't', 'a', 'e'},
        {'i', 'h', 'k', 'r'},
        {'i', 'f', 'l', 'v'}
    };
    String[] words = {"oath", "pea", "eat", "rain"};
    List<String> out = sol.findWords(board, words);
    assertEquals(Arrays.asList("eat", "oath"), sorted(out));
  }

  @Test
  @DisplayName("Overlapping paths and prefix relations")
  void overlappingAndPrefixes() {
    WordSearchII sol = new WordSearchII();
    char[][] board = {
        {'a', 'b'},
        {'c', 'd'}
    };
    String[] words = {"ab", "abc", "abd", "abcd", "ad"};
    // "ab" and "abd" exist; "abc"/"abcd" require reuse of the same cell, invalid; "ad" not contiguous
    List<String> out = sol.findWords(board, words);
    assertEquals(Arrays.asList("ab", "abd"), sorted(out));
  }

  @Test
  @DisplayName("Duplicate words in input should appear once in output")
  void duplicatesInDictionary() {
    WordSearchII sol = new WordSearchII();
    char[][] board = {
        {'a', 'a'},
        {'a', 'a'}
    };
    String[] words = {"aa", "aa", "aaaa"};
    // "aa" exists; "aaaa" also exists via a 4-length path without reuse rules violation
    List<String> out = sol.findWords(board, words);
    assertEquals(Arrays.asList("aa", "aaaa"), sorted(out));
  }

  @Test
  @DisplayName("No words found")
  void noneFound() {
    WordSearchII sol = new WordSearchII();
    char[][] board = {
        {'x', 'y'},
        {'z', 'w'}
    };
    String[] words = {"aa", "bb"};
    List<String> out = sol.findWords(board, words);
    assertEquals(Collections.emptyList(), out);
  }

  @Test
  @DisplayName("Single cell board and one-letter words")
  void singleCell() {
    WordSearchII sol = new WordSearchII();
    char[][] board = {{'q'}};
    String[] words = {"q", "a"};
    List<String> out = sol.findWords(board, words);
    assertEquals(Collections.singletonList("q"), out);
  }

  @Test
  @DisplayName("Handles empty inputs safely")
  void emptyInputs() {
    WordSearchII sol = new WordSearchII();
    char[][] emptyBoard = new char[][]{};
    String[] words = {"a"};
    assertEquals(Collections.emptyList(), sol.findWords(emptyBoard, words));

    char[][] board = {{'a'}};
    String[] emptyWords = new String[]{};
    assertEquals(Collections.emptyList(), sol.findWords(board, emptyWords));
  }
}