package pers.tavish.solution.medium;

import org.junit.Test;

/*

Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    1. Each row must contain the digits 1-9 without repetition.
    2. Each column must contain the digits 1-9 without repetition.
    3. Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:
Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true

Example 2:
Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

Note:

    - A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    - Only the filled cells need to be validated according to the mentioned rules.
    - The given board contain only digits 1-9 and the character '.'.
    - The given board size is always 9x9.

for more information: https://leetcode.com/problems/valid-sudoku/description/
*/

public class ValidSudoku {
    
    public boolean isValidSudoku(char[][] board) {
        return validSubBoxes(board) && validRow(board) && validColumn(board);
    }

    // check sub-boxes
    private boolean validSubBoxes(char[][] board) {
        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j <= 6; j += 3) {
                if (!check(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check(char[][] board, int i, int j) {
        boolean[] valid = new boolean[10];
        for (int m = i; m <= i + 2; m++) {
            for (int n = j; n <= j + 2; n++) {
                char c = board[m][n];
                if (c != '.') {
                    if (!valid[c - '0']) {
                        valid[c - '0'] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // check row
    private boolean validRow(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] valid = new boolean[10];
            for (char c : board[i]) {
                if (c != '.') {
                    if (!valid[c - '0']) {
                        valid[c - '0'] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // check column
    private boolean validColumn(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] valid = new boolean[10];
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c != '.') {
                    if (!valid[c - '0']) {
                        valid[c - '0'] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Test
    public void testCase() {
        char[][] board = {
                {'.','5','.'},
                {'3','.','.'},
                {'.','.','3'}
        };
        System.out.println(check(board, 0, 0));
    }
}
