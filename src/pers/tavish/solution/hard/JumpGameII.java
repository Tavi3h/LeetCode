package pers.tavish.solution.hard;

/*

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:
Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.

Note:

You can assume that you can always reach the last index.

for more information: https://leetcode.com/problems/jump-game-ii/description/ 
*/

public class JumpGameII {

    public int jump(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }
        int curr = 0, currJump = nums[0], max = Integer.MIN_VALUE, steps = 1;
        if (currJump >= nums.length - 1) {
            return 1;
        }
        while (true) {
            for (int i = curr; i <= currJump; i++) {
                max = Math.max(max, nums[i] + i);
            }
            if (max >= nums.length - 1) {
                return steps + 1;
            } else {
                curr = currJump;
                currJump = max;
                steps++;
            }
        }
    }
}
