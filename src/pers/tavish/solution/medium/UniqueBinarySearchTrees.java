package pers.tavish.solution.medium;

import org.junit.Test;

/*

Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

for more information: https://leetcode.com/problems/unique-binary-search-trees/description/
*/

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int left = 0, right = i - left - 1; right >= 0; ++left, --right) {
                dp[i] += dp[left] * dp[right];
            }
        }
        return dp[n];
    }

    @Test
    public void testCase() {
        System.out.println(numTrees(6));
    }
}
