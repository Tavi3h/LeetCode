package pers.tavish.solution.medium;

import org.junit.Test;

/*

 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:
Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

for more information: https://leetcode.com/problems/unique-paths-ii/description/
*/

public class UniquePathsII {
    
    // O(1) space
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid[0].length, n = obstacleGrid.length;

        if (m == 1 && n == 1) {
            return 1;
        }

        for (int i = 1; i < m; i++) {
            if (obstacleGrid[0][i] != 1) {
                obstacleGrid[0][i] = 1;
            } else {
                if (n == 1) {
                    return 0;
                }
                for (int j = i; j < m; j++) {
                    obstacleGrid[0][j] = 0;
                }
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            if (obstacleGrid[i][0] != 1) {
                obstacleGrid[i][0] = 1;
            } else {
                if (m == 1) {
                    return 0;
                }
                for (int j = i; j < n; j++) {
                    obstacleGrid[j][0] = 0;
                }
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }

        return obstacleGrid[n - 1][m - 1];
    }
    
    @Test
    public void testCase() {
        
        int[][] grid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        
        System.out.println(uniquePathsWithObstacles(grid));
    }
}
