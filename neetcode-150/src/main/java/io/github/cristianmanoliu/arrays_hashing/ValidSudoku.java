package io.github.cristianmanoliu.arrays_hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

  private static final int SIZE = 9;

  public boolean isValidSudoku(char[][] board) {
    Map<Integer, Set<Character>> rowMap = new HashMap<>();
    Map<Integer, Set<Character>> colMap = new HashMap<>();
    Map<String, Set<Character>> boxMap = new HashMap<>();

    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        // Skip empty cells
        char c = board[i][j];
        if (c == '.') {
          continue;  // nothing to check
        }

        // Row check
        if (!rowMap
            .computeIfAbsent(i, k -> new HashSet<>())
            .add(c)) {
          return false;
        }

        // Column check
        if (!colMap
            .computeIfAbsent(j, k -> new HashSet<>())
            .add(c)) {
          return false;
        }

        // 3×3 box check: key = "boxRow,boxCol"
        String boxKey = (i / 3) + "," + (j / 3);
        if (!boxMap
            .computeIfAbsent(boxKey, k -> new HashSet<>())
            .add(c)) {
          return false;
        }
      }
    }

    // no duplicates detected
    return true;
  }
}
