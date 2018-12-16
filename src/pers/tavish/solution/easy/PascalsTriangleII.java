package pers.tavish.solution.easy;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/*

Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?

for more information: https://leetcode.com/problems/pascals-triangle-ii/description/
*/

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        Integer[] res = new Integer[rowIndex + 1];
        res[0] = 1;
        for (int i = 1; i <= rowIndex; ++i) {
            for (int j = i; j >= 1; --j) {
                res[j] = res[j - 1] + (res[j] == null ? 0 : res[j]);
            }
        }
        return Arrays.asList(res);
    }

    @Test
    public void testCase() {
        System.out.println(getRow(2));
    }
}
