package pers.tavish.solution.medium;

/*

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

for more information : https://leetcode.com/problems/word-search/description/
*/

// dfs
public class WordSearch {
    public boolean exist(char[][] board, String word) {

        if (board.length == 0 || board[0].length == 0) {
            return false;
        }

        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int i, int j, int idx) {

        if (idx == word.length()) {
            return true;
        }

        int m = board.length, n = board[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(idx)) {
            return false;
        }

        char c = board[i][j];
        board[i][j] = '#';

        boolean res = search(board, word, i - 1, j, idx + 1) 
                       || search(board, word, i + 1, j, idx + 1)
                       || search(board, word, i, j - 1, idx + 1) 
                       || search(board, word, i, j + 1, idx + 1);
        board[i][j] = c;
        return res;
    }
}
