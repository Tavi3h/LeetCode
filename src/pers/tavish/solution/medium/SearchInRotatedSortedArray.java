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

        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[hi]) {
                if (nums[mid] < target && nums[hi] >= target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                if (nums[lo] <= target && nums[mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void testCase() {
        int[] nums = { 7, 8, 9, 0, 2, 3, 4, 5, 6 };
        int target = 5;
        System.out.println(search(nums, target));
    }
}
