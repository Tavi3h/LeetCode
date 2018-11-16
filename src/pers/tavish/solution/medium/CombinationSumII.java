package pers.tavish.solution.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

    - All numbers (including target) will be positive integers.
    - The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]

for more information: https://leetcode.com/problems/combination-sum-ii/description/
*/

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return ans;
        }

        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, tmp, ans);
        return ans;
    }

    private boolean combinationSum2(int[] candidates, int target, int start, List<Integer> tmp,
            List<List<Integer>> ans) {
        if (target < 0) {
            return false;
        }
        
        if (target == 0) {
            ans.add(new ArrayList<>(tmp));
            return false;
        }

        for (int i = start; i < candidates.length; i++) {

            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            tmp.add(candidates[i]);
            int newtarget = target - candidates[i];
            boolean flag = combinationSum2(candidates, newtarget, i + 1, tmp, ans);
            tmp.remove(tmp.size() - 1);
            if (!flag) {
                break;
            }
        }
        return true;
    }
}
