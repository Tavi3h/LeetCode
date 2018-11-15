package pers.tavish.solution.hard;

/*

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

    1. Each of the digits 1-9 must occur exactly once in each row.
    2. Each of the digits 1-9 must occur exactly once in each column.
    3. Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.

Empty cells are indicated by the character '.'.

Note:

    The given board contain only digits 1-9 and the character '.'.
    You may assume that the given Sudoku puzzle will have a single unique solution.
    The given board size is always 9x9.
    
for more information: https://leetcode.com/problems/sudoku-solver/description/
*/

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char c) {
        for (int row = 0; row < 9; row++) {
            if (board[row][j] == c) {
                return false;
            }
        }
        for (int col = 0; col < 9; col++) {
            if (board[i][col] == c) {
                return false;
            }
        }
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
                if (board[row][col] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}
