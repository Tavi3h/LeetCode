package pers.tavish.solution.medium;

import org.junit.Test;

/*

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

for more information: https://leetcode.com/problems/search-in-rotated-sorted-array/description/
*/

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        return nums == null || nums.length == 0 ? -1 : search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int lo, int hi) {
        if (nums[lo] <= nums[hi] && (target < nums[lo] || target > nums[hi])) {
            return -1;
        }
        
        int mid = (lo + hi + 1) / 2;

        if (target == nums[mid]) {
            return mid;
        } else {
            int ans = search(nums, target, lo, mid - 1);
            return ans != -1 ? ans : search(nums, target, mid, hi);
        }
    }

    @Test
    public void testCase() {
        int[] nums = { 1 };
        int target = 1;
        System.out.println(search(nums, target));
    }
}
