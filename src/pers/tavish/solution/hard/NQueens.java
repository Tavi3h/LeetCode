package pers.tavish.solution.hard;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:
Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.

for more information: https://leetcode.com/problems/n-queens/description/
*/

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] solve = new char[n][n]; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                solve[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        solveNQueens(0, solve, result);
        return result;
    }

    private void solveNQueens(int i, char[][] solve, List<List<String>> result) {
        
        if (i == solve.length) {
            List<String> tmp = new ArrayList<>();
            for (char[] chars : solve) {
                tmp.add(new String(chars));
            }
            result.add(tmp);
            return;
        }
        
        for (int j = 0; j < solve.length; j++) {
            if (check(solve, i, j)) {
                solve[i][j] = 'Q';
                solveNQueens(i + 1, solve, result);
                solve[i][j] = '.';
            }
        }
    }

    private boolean check(char[][] solve, int i, int j) {

        // check col
        for (int n = i - 1; n >= 0; n--) {
            if (solve[n][j] != '.') {
                return false;
            }
        }

        // check forward slash
        for (int n = i - 1, m = j + 1; n >= 0 && m <= solve.length - 1; n--, m++) {
            if (solve[n][m] != '.') {
                return false;
            }
        }

        // check back slash
        for (int n = i - 1, m = j - 1; n >= 0 && m >= 0; n--, m--) {
            if (solve[n][m] != '.') {
                return false;
            }
        }

        return true;
    }

    @Test
    public void testCase() {
        System.out.println(solveNQueens(13).size());
    }
}
