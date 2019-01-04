package pers.tavish.solution.hard;

/*

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:
Input: [1,3,5]
Output: 1

Example 2:
Input: [2,2,2,0,1]
Output: 0
Note:

    - This is a follow up problem to Find Minimum in Rotated Sorted Array.
    - Would allow duplicates affect the run-time complexity? How and why?

for more information: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
*/

public class FindMinimumInRotatedSortedArrayII {
    
    // O(logN), O(N) at worst
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            if (nums[lo] == nums[hi]) {
                ++lo;
                continue;
            }
            if (nums[lo] < nums[hi]) {
                return nums[lo];
            }
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= nums[lo]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
    
/*
 * O(N)    
    public int findMin(int[] nums) {
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i + 1] < nums[i]) {
                return nums[i + 1];
            }
        }
        return nums[0];
    }
 */
}
