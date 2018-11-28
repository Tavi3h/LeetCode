package pers.tavish.solution.medium;

/*

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

for more information: https://leetcode.com/problems/minimum-path-sum/description/
*/

public class MinimumPathSum {
    
    // Bottom-up
    public int minPathSum(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; ++i) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }

        for (int i = 1; i < m; ++i) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
    
/*
 * Top-down
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        return minPathSum(grid, dp, m - 1, n - 1);
    }

    private int minPathSum(int[][] grid, int[][] dp, int m, int n) {
        
        if (m == 0 && n == 0) {
            return dp[0][0];
        } else if (m == 0) {
            dp[0][n] = minPathSum(grid, dp, 0, n - 1) + grid[0][n];
            return dp[0][n];
        } else if (n == 0) {
            dp[m][0] = minPathSum(grid, dp, m - 1, 0) + grid[m][0];
            return dp[m][0];
        } else {
            if (dp[m][n] != 0) {
                return dp[m][n];
            } else {
                dp[m][n] = grid[m][n] + Math.min(minPathSum(grid, dp, m - 1, n), minPathSum(grid, dp, m, n - 1));
                return dp[m][n];
            }
        }
    }
*/
}
