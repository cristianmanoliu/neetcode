package io.github.cristianmanoliu.trie;

// https://neetcode.io/problems/implement-prefix-tree?list=neetcode150
public class PrefixTree {

  private final TrieNode root;

  public PrefixTree() {
    this.root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode current = root;
    for (char ch : word.toCharArray()) {
      int index = ch - 'a';
      if (current.children[index] == null) {
        current.children[index] = new TrieNode();
      }
      current = current.children[index];
    }
    current.isEndOfWord = true;
  }

  public boolean search(String word) {
    TrieNode node = findNode(word);
    return node != null && node.isEndOfWord;
  }

  public boolean startsWith(String prefix) {
    return findNode(prefix) != null;
  }

  private TrieNode findNode(String str) {
    TrieNode current = root;
    for (char ch : str.toCharArray()) {
      int index = ch - 'a';
      if (current.children[index] == null) {
        return null;
      }
      current = current.children[index];
    }
    return current;
  }

  private static class TrieNode {

    private final TrieNode[] children;
    private boolean isEndOfWord;

    public TrieNode() {
      this.children = new TrieNode[26];
      this.isEndOfWord = false;
    }
  }
}
