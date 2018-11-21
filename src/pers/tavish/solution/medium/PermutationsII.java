package pers.tavish.solution.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/*

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:
Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

for more information: https://leetcode.com/problems/permutations-ii/description/
*/

// dfs
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] nums, boolean[] visited, List<Integer> partition, List<List<Integer>> result) {
        if (partition.size() == nums.length) {
            result.add(new ArrayList<>(partition));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            partition.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, partition, result);
            visited[i] = false;
            partition.remove(partition.size() - 1);
        }
    }

    @Test
    public void testCase() {
        int[] nums = { 1, 1, 2 };
        System.out.println(permuteUnique(nums));
    }
}
