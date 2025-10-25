package io.github.cristianmanoliu.trie;

// https://neetcode.io/problems/implement-prefix-tree?list=neetcode150
// https://leetcode.com/problems/implement-trie-prefix-tree
public class PrefixTree {

  private final TrieNode root = new TrieNode();

  // Map a character to [0..25]; normalize to lowercase and validate.
  private static int idx(char ch) {
    // In ASCII, 'A'..'Z' (0x41..0x5A) and 'a'..'z' (0x61..0x7A) differ by the 0x20 bit.
    char c = (char) (ch | 0x20); // fast toLowerCase for ASCII letters
    int idx = c - 'a';
    if (idx < 0 || idx >= 26) {
      throw new IllegalArgumentException("Unsupported character: '" + ch + "'. Expected a-z or A-Z.");
    }
    return idx;
  }

  private static void requireNonNull(Object o, String name) {
    if (o == null) {
      throw new IllegalArgumentException(name + " must not be null");
    }
  }

  public void insert(String word) {
    requireNonNull(word, "word");
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      int idx = idx(word.charAt(i));
      if (cur.children[idx] == null) {
        cur.children[idx] = new TrieNode();
      }
      cur = cur.children[idx];
    }
    cur.isEndOfWord = true;
  }

  public boolean search(String word) {
    requireNonNull(word, "word");
    TrieNode node = findNode(word);
    return node != null && node.isEndOfWord;
  }

  public boolean startsWith(String prefix) {
    requireNonNull(prefix, "prefix");
    return findNode(prefix) != null;
  }

  private TrieNode findNode(String s) {
    TrieNode cur = root;
    for (int i = 0; i < s.length(); i++) {
      int idx = idx(s.charAt(i));
      TrieNode next = cur.children[idx];
      if (next == null) {
        return null;
      }
      cur = next;
    }
    return cur;
  }

  private static final class TrieNode {

    private final TrieNode[] children = new TrieNode[26];
    private boolean isEndOfWord;
  }
}