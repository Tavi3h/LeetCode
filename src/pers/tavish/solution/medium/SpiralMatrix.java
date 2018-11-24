package pers.tavish.solution.medium;

import java.util.ArrayList;
import java.util.List;

/*

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

for more information: https://leetcode.com/problems/spiral-matrix/description/
*/

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] arr) {
        List<Integer> res = new ArrayList<>();
        if (arr.length == 0) {
            return res;
        }
        int rows = arr.length, cols = arr[0].length, layers = (int) Math.ceil((Math.min(rows, cols)) / 2d);
        for (int i = 0; i < layers; i++) {
            for (int k = i; k < cols - i; k++) {
                res.add(arr[i][k]);
            }
            for (int j = i + 1; j < rows - i; j++) {
                res.add(arr[j][cols - i - 1]);
            }
            for (int k = cols - i - 2; k >= i && rows - i - 1 != i; k--) {
                res.add(arr[rows - i - 1][k]);
            }
            for (int j = rows - i - 2; j > i && cols - i - 1 != i; j--) {
                res.add(arr[j][i]);
            }
        }
        return res;
    }
}
