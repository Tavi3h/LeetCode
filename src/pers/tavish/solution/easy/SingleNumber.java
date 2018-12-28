package pers.tavish.solution.easy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*

Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:
Input: [2,2,1]
Output: 1

Example 2:
Input: [4,1,2,1,2]
Output: 4

for more information: https://leetcode.com/problems/single-number/description/
*/

public class SingleNumber {

    // XOR
    // {a,b,c,a,b}
    // 0^a^b^c^a^b = 0^a^a^b^b^c = c
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
    
    @Test
    public void testCase() {
        int[] nums = { 1, 2, 3, 1, 2 };
        assertEquals(singleNumber(nums), 3);
    }
    
/*
 * using Map
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        
        return -1;
    }
 */
}
