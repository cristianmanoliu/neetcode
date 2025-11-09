package io.github.cristianmanoliu.backtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SubsetsTest {

  @Test
  @DisplayName("Null input throws IllegalArgumentException")
  void nullInput() {
    Subsets sol = new Subsets();
    assertThrows(IllegalArgumentException.class, () -> sol.subsets(null));
  }

  @Test
  @DisplayName("Empty array -> only empty subset")
  void emptyArray() {
    Subsets sol = new Subsets();
    List<List<Integer>> result = sol.subsets(new int[]{});

    assertEquals(1, result.size());
    assertTrue(result.contains(List.of())); // only the empty subset
  }

  @Test
  @DisplayName("Single element -> empty and singleton subsets")
  void singleElement() {
    Subsets sol = new Subsets();
    List<List<Integer>> result = sol.subsets(new int[]{1});

    assertEquals(2, result.size());
    assertTrue(result.contains(List.of()));
    assertTrue(result.contains(List.of(1)));
  }

  @Test
  @DisplayName("Two elements -> 4 subsets total")
  void twoElements() {
    Subsets sol = new Subsets();
    List<List<Integer>> result = sol.subsets(new int[]{1, 2});

    // Subsets: [], [1], [2], [1,2]
    assertEquals(4, result.size());
    assertTrue(result.contains(List.of()));
    assertTrue(result.contains(List.of(1)));
    assertTrue(result.contains(List.of(2)));
    assertTrue(result.contains(List.of(1, 2)));
  }

  @Test
  @DisplayName("Three elements -> 8 subsets including all combinations")
  void threeElements() {
    Subsets sol = new Subsets();
    List<List<Integer>> result = sol.subsets(new int[]{1, 2, 3});

    // There should be 2^3 = 8 subsets.
    assertEquals(8, result.size());

    // Check a few canonical ones.
    assertTrue(result.contains(List.of()));
    assertTrue(result.contains(List.of(1)));
    assertTrue(result.contains(List.of(2)));
    assertTrue(result.contains(List.of(3)));
    assertTrue(result.contains(List.of(1, 2)));
    assertTrue(result.contains(List.of(1, 3)));
    assertTrue(result.contains(List.of(2, 3)));
    assertTrue(result.contains(List.of(1, 2, 3)));
  }
}
