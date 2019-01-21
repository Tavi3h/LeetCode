package pers.tavish.solution.easy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:
Input: [3,2,3]
Output: 3

Example 2:
Input: [2,2,1,1,1,2,2]
Output: 2

for more information: https://leetcode.com/problems/majority-element/description/
*/

public class MajorityElement {
    
/*
 * O(N) time, O(N) space
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) > nums.length / 2) {
                return i;
            }
        }
        return -1;
    }
 */
    
    // O(N) time, O(1) space
    public int majorityElement(int[] nums) {
        int count = 0, ans = nums[0];
        for (int k : nums) {
            if (count == 0) {
                ans = k;
            }
            if (ans == k) {
                count++;
            } else {
                count--;
            }
        }
        return ans;
    }
    
    @Test
    public void testCase() {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2, 3, 2, 2, 3 };
        assertEquals(majorityElement(nums), 2);
    }
}
