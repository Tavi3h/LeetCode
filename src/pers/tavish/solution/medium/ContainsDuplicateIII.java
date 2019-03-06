package pers.tavish.solution.medium;

import static org.junit.Assert.assertEquals;

import java.util.TreeSet;

import org.junit.Test;

/*

Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:
Input: nums = [1,2,3,1], k = 3, t = 0
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1, t = 2
Output: true

Example 3:
Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false

for more information: https://leetcode.com/problems/contains-duplicate-iii/
*/

public class ContainsDuplicateIII {

    // sliding window with TreeSet
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i >= k + 1) {
                treeSet.remove((long) nums[i - k - 1]);
            }
            Long ceiling = treeSet.ceiling((long) nums[i]), floor = treeSet.floor((long) nums[i]);
            if ((ceiling != null && t >= Math.abs(ceiling - nums[i])) || (floor != null && t >= Math.abs(floor - nums[i]))) {
                return true;
            }
            treeSet.add((long) nums[i]);
        }
        return false;
    }

    @Test
    public void testCase() {
        int[] nums = { 1, 5, 9, 0, 5, 8 };
        assertEquals(true, containsNearbyAlmostDuplicate(nums, 2, 3));
    }
}
