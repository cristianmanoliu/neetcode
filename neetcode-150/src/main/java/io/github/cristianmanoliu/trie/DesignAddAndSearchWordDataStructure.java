package io.github.cristianmanoliu.trie;

// https://neetcode.io/problems/design-word-search-data-structure?list=neetcode150
// https://leetcode.com/problems/design-add-and-search-words-data-structure
public class DesignAddAndSearchWordDataStructure {

  private final TrieNode root;

  public DesignAddAndSearchWordDataStructure() {
    this.root = new TrieNode();
  }

  public void addWord(String word) {
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      int idx = word.charAt(i) - 'a';
      if (cur.child[idx] == null) {
        cur.child[idx] = new TrieNode();
      }
      cur = cur.child[idx];
    }
    cur.isWord = true;
  }

  public boolean search(String word) {
    return dfs(word, 0, root);
  }

  private boolean dfs(String word, int i, TrieNode node) {
    if (node == null) {
      return false;
    }
    if (i == word.length()) {
      return node.isWord;
    }

    char c = word.charAt(i);
    if (c == '.') {
      // Try all 26 children
      for (TrieNode next : node.child) {
        if (dfs(word, i + 1, next)) {
          return true;
        }
      }
      return false;
    } else {
      return dfs(word, i + 1, node.child[c - 'a']);
    }
  }

  private static class TrieNode {

    TrieNode[] child = new TrieNode[26];
    boolean isWord;
  }
}
