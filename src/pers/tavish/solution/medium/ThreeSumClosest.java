package pers.tavish.solution.medium;

import java.util.Arrays;

import org.junit.Test;

/*

Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

for more information: https://leetcode.com/problems/3sum-closest/description/
*/

public class ThreeSumClosest {

    @Test
    public void testCase() {
        int[] nums = { -1, 2, 1, -4 };
        System.out.println(threeSumClosest(nums, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int distance = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 0; i < nums.length - 2; ++i) {
            int m = i + 1;
            int n = nums.length - 1;
            while (n > m) {
                int sum = nums[i] + nums[m] + nums[n];
                int substract = target - sum;
                int curDis = Math.abs(substract);
                if (curDis < distance) {
                    answer = sum;
                    distance = curDis;
                }
                if (substract > 0) {
                    ++m;
                } else {
                    --n;
                }
            }
        }
        return answer;
    }
}
