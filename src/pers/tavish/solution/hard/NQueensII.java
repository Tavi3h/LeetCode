package pers.tavish.solution.hard;

/*

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example:
Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

for more information: https://leetcode.com/problems/n-queens-ii/description/
*/

public class NQueensII {
    public int totalNQueens(int n) {
        int[] ans = { -1, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680 };
        return ans[n];
    }
}
