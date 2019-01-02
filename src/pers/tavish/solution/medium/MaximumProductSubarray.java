package pers.tavish.solution.medium;

import org.junit.Test;

/*

Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

for more information: https://leetcode.com/problems/maximum-product-subarray/description/
*/

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max_local = nums[0], min_local = nums[0], global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max_copy = max_local;
            max_local = Math.max(Math.max(nums[i] * max_local, nums[i]), nums[i] * min_local);
            min_local = Math.min(Math.min(nums[i] * max_copy, nums[i]), nums[i] * min_local);
            global = Math.max(global, max_local);
        }
        return global;
    }

    @Test
    public void testCase() {
        int[] nums = { 4, 1, -1, -2, 3, -4, 2, -2 };
        System.out.println(maxProduct(nums));
    }
}
