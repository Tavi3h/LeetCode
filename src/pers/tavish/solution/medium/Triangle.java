package pers.tavish.solution.medium;

import java.util.List;

/*

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

for more information: https://leetcode.com/problems/triangle/description/
*/

public class Triangle {
    // bottom-up
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; --i) {
            List<Integer> pre = triangle.get(i);
            for (int j = 0; j < pre.size(); ++j) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + pre.get(j);
            }
        }
        return dp[0];
    }
}
