package io.github.cristianmanoliu.arrays_hashing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidSudokuTest {

  private final ValidSudoku sol = new ValidSudoku();

  // Helper: build a char[][] board from an array of 9 strings of length 9
  private char[][] boardFrom(String[] rows) {
    char[][] b = new char[9][9];
    for (int i = 0; i < 9; i++) {
      b[i] = rows[i].toCharArray();
    }
    return b;
  }

  @Test
  @DisplayName("LeetCode valid example with dots -> true")
  void validExample() {
    char[][] board = boardFrom(new String[]{
        "53..7....",
        "6..195...",
        ".98....6.",
        "8...6...3",
        "4..8.3..1",
        "7...2...6",
        ".6....28.",
        "...419..5",
        "....8..79"
    });
    assertTrue(sol.isValidSudoku(board));
  }

  @Test
  @DisplayName("Duplicate in a row -> false")
  void duplicateRow() {
    char[][] board = boardFrom(new String[]{
        "53..7....",
        "6..195...",
        ".98....6.",
        "8...6...3",
        "4..8.3..1",
        "7...2...6",
        ".6....28.",
        "...419..5",
        "....8..79"
    });
    // Introduce a duplicate '5' in row 0 (already has '5' at col 0)
    board[0][1] = '5';
    assertFalse(sol.isValidSudoku(board));
  }

  @Test
  @DisplayName("Duplicate in a column -> false")
  void duplicateColumn() {
    char[][] board = boardFrom(new String[]{
        "53..7....",
        "6..195...",
        ".98....6.",
        "8...6...3",
        "4..8.3..1",
        "7...2...6",
        ".6....28.",
        "...419..5",
        "....8..79"
    });
    // Put '6' at (0,0) creating column duplicate with (1,0)
    board[0][0] = '6';
    assertFalse(sol.isValidSudoku(board));
  }

  @Test
  @DisplayName("Duplicate in a 3x3 box -> false")
  void duplicateBox() {
    char[][] board = boardFrom(new String[]{
        "53..7....",
        "6..195...",
        ".98....6.",
        "8...6...3",
        "4..8.3..1",
        "7...2...6",
        ".6....28.",
        "...419..5",
        "....8..79"
    });
    // Top-left box currently has '5' at (0,0). Add another '5' in same box at (1,1).
    board[1][1] = '5';
    assertFalse(sol.isValidSudoku(board));
  }

  @Test
  @DisplayName("All dots (empty board) -> valid")
  void allDots() {
    char[][] board = boardFrom(new String[]{
        ".........",
        ".........",
        ".........",
        ".........",
        ".........",
        ".........",
        ".........",
        ".........",
        "........."
    });
    assertTrue(sol.isValidSudoku(board));
  }

  @Test
  @DisplayName("Nearly complete valid board -> true")
  void nearlyCompleteValid() {
    char[][] board = boardFrom(new String[]{
        "534678912",
        "672195348",
        "198342567",
        "859761423",
        "426853791",
        "713924856",
        "961537284",
        "287419635",
        "34528617." // last cell empty instead of '9'
    });
    assertTrue(sol.isValidSudoku(board));
  }
}
