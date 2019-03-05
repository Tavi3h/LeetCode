package pers.tavish.solution.hard;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Example 1:
Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.

Example 2:
Input: [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.

Note:

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
Try to solve it in linear time/space.

for more information: https://leetcode.com/problems/maximum-gap/description/
*/

public class MaximumGap {
    
    // radix sort
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        
        int exp = 1, radix = 10;
        int[] aux = new int[nums.length];
        
        while (maxVal / exp > 0) {
            int[] count = new int[radix];
            
            for (int i = 0; i < nums.length; i++) {
                ++count[(nums[i] / exp) % radix];
            }
            
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }
            
            for (int i = nums.length - 1; i >= 0; i--) {
                aux[--count[(nums[i] / exp) % radix]] = nums[i];
            }
            
            for (int i = 0; i < nums.length; i++) {
                nums[i] = aux[i];
            }
            
            exp *= 10;
        }
        
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        
        return res;
    }

    @Test
    public void testCase() {
        int[] nums = { 20, 2, 3, 6, 1, 1, 2, 8, 13 };
        assertEquals(7, maximumGap(nums));
    }
}
