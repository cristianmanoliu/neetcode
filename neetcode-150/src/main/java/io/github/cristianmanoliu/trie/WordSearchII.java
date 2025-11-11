package io.github.cristianmanoliu.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://neetcode.io/problems/search-for-word-ii?list=neetcode150
// https://leetcode.com/problems/word-search-ii/
public class WordSearchII {

  // Main function: return all words that can be formed by sequentially adjacent letters
  // (up, down, left, right) on the board. A cell may not be used more than once per word.
  // Strategy:
  // 1) Build a Trie of the given words. Each node may store 'word' when a word ends here.
  // 2) For each board cell, DFS into the Trie:
  //    - If next Trie edge doesn't exist for the cell's char, prune immediately.
  //    - When reaching a node with node.word != null, we found one word → add it and set node.word=null to avoid duplicates.
  // 3) Use in-place marking (e.g., board[r][c] = '#') to avoid revisiting a cell in the current path, then restore it.
  // 4) Optional optimization: Trie pruning — after returning from DFS, if a child node has no further children and no word,
  //    set the corresponding parent child pointer to null to shrink the search space as we go.
  public List<String> findWords(char[][] board, String[] words) {
    // Edge cases: null or empty inputs
    if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
      return Collections.emptyList();
    }

    // Build Trie from the list of words
    TrieNode root = new TrieNode();
    for (String w : words) {
      insert(root, w);
    }

    int rows = board.length;
    int cols = board[0].length;
    List<String> result = new ArrayList<>();

    // DFS from every cell
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        dfs(board, r, c, root, result);
      }
    }
    return result;
  }

  // Insert a word into the Trie.
  private void insert(TrieNode root, String word) {
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      int idx = word.charAt(i) - 'a';
      if (cur.next[idx] == null) {
        cur.next[idx] = new TrieNode();
      }
      cur = cur.next[idx];
    }
    // Store the whole word at the terminal node (used to output and avoid duplicates)
    if (cur.word == null) {
      cur.word = word;
    }
  }

  // DFS search from (r,c), advancing in the Trie and collecting found words.
  private void dfs(char[][] board, int r, int c, TrieNode node, List<String> out) {
    char ch = board[r][c];
    // '#' means visited; if visited or no such child, stop.
    if (ch == '#') {
      return;
    }
    int idx = ch - 'a';
    TrieNode nextNode = (idx >= 0 && idx < 26) ? node.next[idx] : null;
    if (nextNode == null) {
      return; // No word with this prefix
    }

    // If this Trie node stores a word, we found it.
    if (nextNode.word != null) {
      out.add(nextNode.word);
      nextNode.word = null; // Avoid duplicates (each word should be added once)
    }

    // Mark current cell as visited
    board[r][c] = '#';

    // Explore 4 directions
    if (r + 1 < board.length) {
      dfs(board, r + 1, c, nextNode, out);
    }
    if (r - 1 >= 0) {
      dfs(board, r - 1, c, nextNode, out);
    }
    if (c + 1 < board[0].length) {
      dfs(board, r, c + 1, nextNode, out);
    }
    if (c - 1 >= 0) {
      dfs(board, r, c - 1, nextNode, out);
    }

    // Restore cell
    board[r][c] = ch;

    // Optional pruning: if nextNode has no children and no word, unlink it to reduce future work
    if (isLeaf(nextNode)) {
      node.next[idx] = null;
    }
  }

  // Check if a Trie node has no children and no terminal word.
  private boolean isLeaf(TrieNode node) {
    if (node.word != null) {
      return false;
    }
    for (TrieNode child : node.next) {
      if (child != null) {
        return false;
      }
    }
    return true;
  }

  // Basic Trie node for lowercase 'a'..'z'
  private static class TrieNode {

    TrieNode[] next = new TrieNode[26]; // children
    String word;                        // non-null means a word ends here
  }
}