package pers.tavish.solution.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/*

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

    - All numbers (including target) will be positive integers.
    - The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

for more information: https://leetcode.com/problems/combination-sum/description/
*/

public class CombinationSum {

    // backtracking
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return ans;
        }

        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, tmp, ans);
        return ans;
    }

    private boolean combinationSum(int[] candidates, int target, int start, List<Integer> tmp,
            List<List<Integer>> ans) {
        if (target < 0) {
            return false;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(tmp));
            return false;
        }

        for (int i = start; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            int newtarget = target - candidates[i];
            boolean flag = combinationSum(candidates, newtarget, i, tmp, ans);
            tmp.remove(tmp.size() - 1);
            if (!flag) {
                break;
            }
        }
        return true;
    }

    @Test
    public void testCase() {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        combinationSum(candidates, target);
    }
}
