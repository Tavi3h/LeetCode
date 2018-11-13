package pers.tavish.solution.medium;

import java.util.Arrays;

import org.junit.Test;

/*

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

for more information: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
*/

public class FindFirstAndLastPositionOfElementInSortedArray {
    // 最坏情况O(N)
    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }

        int ans = Arrays.binarySearch(nums, target);
        if (ans < 0) {
            return new int[] { -1, -1 };
        }
        int l = ans, r = ans;
        while (l >= 0 && nums[l] == target) {
            l--;
        }
        while (r <= nums.length - 1 && nums[r] == target) {
            r++;
        }
        return new int[] { l + 1, r - 1 };
    }

    @Test
    public void testCase() {
        int[] nums = { 8 };
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
