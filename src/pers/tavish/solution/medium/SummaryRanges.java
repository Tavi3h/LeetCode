package pers.tavish.solution.medium;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*

Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:
Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.

Example 2:
Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.

for more information: https://leetcode.com/problems/summary-ranges/
*/

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums != null && nums.length != 0) {
            int i = 0, j = 0;
            while (j < nums.length) {
                if (j == nums.length - 1) {
                    summaryRanges(res, nums, i, ++j);
                } else if (nums[++j] - nums[j - 1] != 1) {
                    summaryRanges(res, nums, i, j);
                    i = j;
                }
            }
        }
        return res;
    }

    private void summaryRanges(List<String> res, int[] nums, int i, int j) {
        res.add(j - i == 1 ? nums[i] + "" : nums[i] + "->" + nums[j - 1]);
    }

    @Test
    public void testCase() {
        int[] nums = { 0, 2, 3, 4, 6, 8, 9 };
        System.out.println(summaryRanges(nums));
    }
}
