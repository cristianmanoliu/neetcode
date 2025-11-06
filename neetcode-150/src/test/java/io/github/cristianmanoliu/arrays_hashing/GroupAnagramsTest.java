package io.github.cristianmanoliu.arrays_hashing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit 5 tests for GroupAnagrams
class GroupAnagramsTest {

  // Normalize a list of groups by sorting each group and then sorting groups by their first element/size.
  // This lets us compare results regardless of order of groups or order within each group.
  private List<List<String>> normalize(List<List<String>> groups) {
    List<List<String>> copy = new ArrayList<>();
    for (List<String> g : groups) {
      List<String> sorted = new ArrayList<>(g);
      sorted.sort(Comparator.naturalOrder());
      copy.add(sorted);
    }
    copy.sort((a, b) -> {
      // Primary: first element if present
      String a0 = a.isEmpty() ? "" : a.get(0);
      String b0 = b.isEmpty() ? "" : b.get(0);
      int cmp = a0.compareTo(b0);
      if (cmp != 0) {
        return cmp;
      }
      // Secondary: size
      return Integer.compare(a.size(), b.size());
    });
    return copy;
  }

  @Test
  @DisplayName("LeetCode example: [eat, tea, tan, ate, nat, bat]")
  void leetcodeExample() {
    GroupAnagrams sol = new GroupAnagrams();
    String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> out = sol.groupAnagrams(input);

    List<List<String>> expected = Arrays.asList(
        Arrays.asList("ate", "eat", "tea"),
        Arrays.asList("nat", "tan"),
        Arrays.asList("bat")
    );

    assertEquals(normalize(expected), normalize(out));
  }

  @Test
  @DisplayName("Single word -> single group")
  void singleWord() {
    GroupAnagrams sol = new GroupAnagrams();
    String[] input = {"abc"};
    List<List<String>> out = sol.groupAnagrams(input);
    List<List<String>> expected = List.of(List.of("abc"));
    assertEquals(normalize(expected), normalize(out));
  }

  @Test
  @DisplayName("Duplicates of the same word stay in the same group")
  void duplicatesStayTogether() {
    GroupAnagrams sol = new GroupAnagrams();
    String[] input = {"a", "a", "a"};
    List<List<String>> out = sol.groupAnagrams(input);
    List<List<String>> expected = List.of(Arrays.asList("a", "a", "a"));
    assertEquals(normalize(expected), normalize(out));
  }

  @Test
  @DisplayName("Empty strings group together")
  void emptyStrings() {
    GroupAnagrams sol = new GroupAnagrams();
    String[] input = {"", "", "a", "b", "ab", "ba"};
    List<List<String>> out = sol.groupAnagrams(input);

    // FIX: both "" should be in the same group
    List<List<String>> expected = Arrays.asList(
        Arrays.asList("", ""),   // <- one group for both empties
        Arrays.asList("a"),
        Arrays.asList("b"),
        Arrays.asList("ab", "ba")
    );

    assertEquals(normalize(expected), normalize(out));
  }


  @Test
  @DisplayName("Mixed lengths and no anagrams")
  void noAnagrams() {
    GroupAnagrams sol = new GroupAnagrams();
    String[] input = {"abc", "defg", "hijk", "l"};
    List<List<String>> out = sol.groupAnagrams(input);

    List<List<String>> expected = Arrays.asList(
        List.of("abc"), List.of("defg"), List.of("hijk"), List.of("l")
    );
    assertEquals(normalize(expected), normalize(out));
  }
}