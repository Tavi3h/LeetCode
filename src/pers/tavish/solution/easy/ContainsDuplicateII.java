package pers.tavish.solution.easy;

import java.util.HashMap;
import java.util.Map;

/*

Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false

for more information: https://leetcode.com/problems/contains-duplicate-ii/
*/

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int idx = 0; idx < nums.length; idx++) {
            if (!map.containsKey(nums[idx])) {
                map.put(nums[idx], idx);   
            } else {
                if (idx - map.get(nums[idx]) <= k) {
                    return true;
                }
                map.put(nums[idx], idx);   
            }
        }
        return false;
    }
}
