package pers.tavish.solution.medium;

import org.junit.Test;

/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Example 1:
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right

Example 2:
Input: m = 7, n = 3
Output: 28

for more information: https://leetcode.com/problems/unique-paths/description/
*/
public class UniquePaths {
    // bottom-up
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
/*
 * Top-down (TLE)
    public int uniquePaths(int m, int n) {
        return m == 1 || n == 1 ? 1 : uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }
*/
/*
 *  Top-down 
    public int uniquePaths(int m, int n) {
        return uniquePaths(m - 1, n - 1, new int[m][n]);
    }
    
    private int uniquePaths(int m, int n, int[][] map) {
    
        if (m == 0 || n == 0) {
            return 1;
        } else {
            if (map[m][n] != 0) {
                return map[m][n];
            } else {
                map[m][n] = uniquePaths(m - 1, n, map) + uniquePaths(m, n - 1, map);
                return map[m][n];
            }
        }
    }
*/
    @Test
    public void testCase() {
        System.out.println(uniquePaths(7, 3));
    }
}
