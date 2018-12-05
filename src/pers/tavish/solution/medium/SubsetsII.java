package pers.tavish.solution.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/*

Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:
Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

for more information: https://leetcode.com/problems/subsets-ii/description/
*/

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // first sort nums
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
                // skip duplicates
                if (i > level && nums[i] == nums[i - 1]) {
                    continue;
                }
                arrayList.add(nums[i]);
                combine(result, arrayList, nums, k, i + 1);
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }
    
    @Test
    public void testCase() {
        int[] nums = { 1, 2, 2 };
        System.out.println(subsetsWithDup(nums));
    }
}
