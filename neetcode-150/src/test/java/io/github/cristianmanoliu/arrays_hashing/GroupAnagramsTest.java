package io.github.cristianmanoliu.arrays_hashing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class GroupAnagramsTest {

  private final GroupAnagrams groupAnagrams = new GroupAnagrams();

  private Set<Set<String>> toSetOfSets(Collection<List<String>> lists) {
    Set<Set<String>> set = new HashSet<>();
    for (List<String> group : lists) {
      set.add(new HashSet<>(group));
    }
    return set;
  }

  @Test
  void groupsAnagramsForExample1() {
    String[] input = {"act", "pots", "tops", "cat", "stop", "hat"};
    List<List<String>> expected = Arrays.asList(
        Collections.singletonList("hat"),
        Arrays.asList("act", "cat"),
        Arrays.asList("stop", "pots", "tops")
    );
    assertEquals(
        toSetOfSets(expected),
        toSetOfSets(groupAnagrams.groupAnagrams(input))
    );
  }

  @Test
  void groupsAnagramsForSingleElement() {
    String[] input = {"x"};
    List<List<String>> expected = Collections.singletonList(
        Collections.singletonList("x")
    );
    assertEquals(
        toSetOfSets(expected),
        toSetOfSets(groupAnagrams.groupAnagrams(input))
    );
  }

  @Test
  void groupsAnagramsForEmptyString() {
    String[] input = {""};
    List<List<String>> expected = Collections.singletonList(
        Collections.singletonList("")
    );
    assertEquals(
        toSetOfSets(expected),
        toSetOfSets(groupAnagrams.groupAnagrams(input))
    );
  }
}