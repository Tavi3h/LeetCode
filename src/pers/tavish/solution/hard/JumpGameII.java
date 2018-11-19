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
    
    // greedy
    public int jump(int[] nums) {
        int end = 0, farest = 0, steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farest = Math.max(farest, i + nums[i]);
            if (i == end) {
                steps++;
                end = farest;
            }
        }
        return steps;
    }
}
