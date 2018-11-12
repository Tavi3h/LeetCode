package pers.tavish.solution.hard;

import java.util.Arrays;

/*

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

for more information: https://leetcode.com/problems/median-of-two-sorted-arrays/description/
*/

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] nums3 = Arrays.copyOf(nums1, nums1.length + nums2.length);

        System.arraycopy(nums2, 0, nums3, nums1.length, nums2.length);

        Arrays.sort(nums3); // SORT IS NOT GOOD

        int mid = nums3.length / 2;

        return nums3.length % 2 == 0 ? (nums3[mid - 1] + nums3[mid]) / 2d : nums3[mid];

    }
}
