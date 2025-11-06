package io.github.cristianmanoliu.arrays_hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://neetcode.io/problems/valid-sudoku?list=neetcode150
public class ValidSudoku {

  // Sudoku board dimension (9x9)
  private static final int SIZE = 9;

  // Main function: validate that the partially filled Sudoku board is valid.
  // Rules enforced:
  // 1) Each row contains no duplicate digits '1'..'9'.
  // 2) Each column contains no duplicate digits '1'..'9'.
  // 3) Each 3x3 sub-box contains no duplicate digits '1'..'9'.
  // Note: '.' cells are empty and ignored.
  public boolean isValidSudoku(char[][] board) {
    // Maps to remember the digits we've seen per row / per column / per 3x3 box
    Map<Integer, Set<Character>> rowMap = new HashMap<>();
    Map<Integer, Set<Character>> colMap = new HashMap<>();
    Map<String, Set<Character>> boxMap = new HashMap<>();

    // Scan every cell of the 9x9 board
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        // Current cell value
        char c = board[i][j];

        // Skip empty cells ('.' means unfilled)
        if (c == '.') {
          continue;
        }

        // Row check: if 'c' already present in row i -> invalid
        if (!rowMap
            .computeIfAbsent(i, k -> new HashSet<>())
            .add(c)) {
          return false;
        }

        // Column check: if 'c' already present in column j -> invalid
        if (!colMap
            .computeIfAbsent(j, k -> new HashSet<>())
            .add(c)) {
          return false;
        }

        // Box check: 3x3 sub-box identified by (i/3, j/3)
        String boxKey = (i / 3) + "," + (j / 3);
        if (!boxMap
            .computeIfAbsent(boxKey, k -> new HashSet<>())
            .add(c)) {
          return false;
        }
      }
    }

    // If no rule was violated, the board is valid
    return true;
  }
}
