package pers.tavish.solution.medium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    - Integers in each row are sorted in ascending from left to right.
    - Integers in each column are sorted in ascending from top to bottom.

Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

Given target = 5, return true.

Given target = 20, return false.

for more information: https://leetcode.com/problems/search-a-2d-matrix-ii/description/
*/

public class SearchA2DMatrixII {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] > target) {
                --j;
            } else if (matrix[i][j] < target) {
                ++i;
            } else {
                return true;
            }
        }
        return false;
    }
    
    // binarySearch for every row
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix == null || matrix.length == 0) {
//            return false;
//        }
//        for (int i = 0; i < matrix.length; i++) {
//            if (Arrays.binarySearch(matrix[i], target) >= 0) {
//                return true;
//            }
//        }
//        return false;
//    }
    
    @Test
    public void testCase() {
        int[][] matrix = {
                {1,  4,  7,  11, 15},
                {2,  5,  8,  12, 19},
                {3,  6,  9,  16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        assertEquals(true, searchMatrix(matrix, 18));
    }
}
