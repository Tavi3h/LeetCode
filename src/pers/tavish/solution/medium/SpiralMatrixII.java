package pers.tavish.solution.medium;

/*

Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:
Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

for more information: https://leetcode.com/problems/spiral-matrix-ii/description/
*/

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int layers = (int) Math.ceil((Math.min(n, n)) / 2d), m = 1;
        for (int i = 0; i < layers; i++) {
            for (int k = i; k < n - i; k++) {
                ans[i][k] = m++;
            }
            for (int j = i + 1; j < n - i; j++) {
                ans[j][n - i - 1] = m++;
            }
            for (int k = n - i - 2; k >= i && n - i - 1 != i; k--) {
                ans[n - i - 1][k] = m++;
            }
            for (int j = n - i - 2; j > i && n - i - 1 != i; j--) {
                ans[j][i] = m++;
            }
        }
        return ans;
    }
}
