package pers.tavish.solution.medium;

import org.junit.Test;
/*

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:
Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.

for more information: https://leetcode.com/problems/jump-game/description/
*/

public class JumpGame {
    public boolean canJump(int[] nums) {
        int curr = 0, currJump = nums[0], max = Integer.MIN_VALUE;
        if (currJump >= nums.length - 1) {
            return true;
        }
        while (true) {
            for (int i = curr; i <= currJump; i++) {
                max = Math.max(max, nums[i] + i);
            }
            if (max >= nums.length - 1) {
                return true;
            } else if (max == currJump) {
                return false;
            } else {
                curr = currJump;
                currJump = max;
            }
        }
    }

    @Test
    public void testCase() {
        int[] nums = { 1, 1, 2, 2, 0, 1, 1 };
        System.out.println(canJump(nums));
    }
}
