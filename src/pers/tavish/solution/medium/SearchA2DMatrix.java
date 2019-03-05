package pers.tavish.solution.medium;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/*

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    - Integers in each row are sorted from left to right.
    - The first integer of each row is greater than the last integer of the previous row.

Example 1:
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

Example 2:
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false

*/

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length, n = matrix[0].length;

        int[] tails = new int[m];
        for (int i = 0; i < m; i++) {
            tails[i] = matrix[i][n - 1];
        }

        if (target > tails[m - 1]) {
            return false;
        }

        int result = Arrays.binarySearch(tails, target);

        return result >= 0 ? true : Arrays.binarySearch(matrix[-result - 1], target) >= 0;
    }

    @Test
    public void testCase() {
        int[][] arr = { 
                { 1, 3, 5, 7 }, 
                { 10, 11, 16, 20 }, 
                { 23, 30, 34, 50 }
        };
        assertEquals(true, searchMatrix(arr, 1));
        assertEquals(false, searchMatrix(arr, 4));
        assertEquals(true, searchMatrix(arr, 10));
        assertEquals(false, searchMatrix(arr, 21));
        assertEquals(true, searchMatrix(arr, 30));
        assertEquals(false, searchMatrix(arr, 35));
        assertEquals(false, searchMatrix(arr, 70));
    }
}
