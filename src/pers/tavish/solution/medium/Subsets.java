package pers.tavish.solution.medium;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

for more information: https://leetcode.com/problems/subsets/description/
*/

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int k = 0; k <= nums.length; k++) {
            combine(ans, new ArrayList<Integer>(), nums, k, 0);
        }
        return ans;
    }

    private void combine(List<List<Integer>> result, List<Integer> arrayList, int[] nums, int k, int level) {
        if (arrayList.size() == k) {
            result.add(new ArrayList<>(arrayList));
        } else {
            for (int i = level; i < nums.length; i++) {
                arrayList.add(nums[i]);
                combine(result, arrayList, nums, k, i + 1);
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }

    @Test
    public void testCase() {
        int[] nums = { 0, 2, 4, 5 };
        System.out.println(subsets(nums));
    }
}
