package pers.tavish.solution.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/*

Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

for more information: https://leetcode.com/problems/4sum/description/
*/

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int key = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int m = j + 1, n = nums.length - 1;
                while (n > m) {
                    int sum = nums[j] + nums[m] + nums[n];
                    if (sum > key) {
                        --n;
                        while (m < n && nums[n] == nums[n + 1]) {
                            --n;
                        }
                    } else if (sum < key) {
                        ++m;
                        while (m < n && nums[m] == nums[m - 1]) {
                            ++m;
                        }
                    } else {
                        list.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        --n;
                        ++m;
                        while (m < n && nums[n] == nums[n + 1]) {
                            --n;
                        }
                        while (m < n && nums[m] == nums[m - 1]) {
                            ++m;
                        }
                    }
                }
            }
        }

        return list;
    }

    @Test
    public void testCase() {
        int[] nums = { -3, -2, -1, 0, 0, 1, 2, 3 };
        System.out.println(fourSum(nums, 0));
    }
}
