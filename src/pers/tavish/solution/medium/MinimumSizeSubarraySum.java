package pers.tavish.solution.medium;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/*

Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.

Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 

https://leetcode.com/problems/minimum-size-subarray-sum/description/
*/

public class MinimumSizeSubarraySum {
    
    // O(nlogn)
    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length, res = length + 1;
        int[] sums = new int[length + 1];
        for (int i = 1; i < length + 1; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < length + 1; i++) {
            int right = Arrays.binarySearch(sums, i + 1, sums.length, sums[i] + s);
            right = right < 0 ? -right - 1 : right;
            if (right == length + 1) {
                break;
            }
            res = res > right - i ? right - i : res;
        }
        return res == length + 1 ? 0 : res;
    }

    @Test
    public void testCase() {
        int[] nums = { 2, 3, 1, 2, 4, 3, 5};
        assertEquals(2, minSubArrayLen(7, nums));
    }
    
    // O(N)
//    public int minSubArrayLen(int s, int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int left = 0, right = 0, sum = 0, length = nums.length, res = length + 1;
//        while (right < length) {
//            while (sum < s && right < length) {
//                sum += nums[right++];
//            }
//            while (sum >= s) {
//                res = Math.min(res, right - left);
//                sum -= nums[left++];
//            }
//        }
//        return res == length + 1 ? 0 : res;
//    }
}
