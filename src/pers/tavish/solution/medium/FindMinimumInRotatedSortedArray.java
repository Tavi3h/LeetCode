package pers.tavish.solution.medium;

/*

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:
Input: [3,4,5,1,2] 
Output: 1

Example 2:
Input: [4,5,6,7,0,1,2]
Output: 0

for more information: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
*/

public class FindMinimumInRotatedSortedArray {
    
    // O(logN)
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (nums[lo] > nums[hi]) {
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
