package pers.tavish.solution.medium;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/*

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

for more information: https://leetcode.com/problems/permutations/description/
*/

public class Permutations {
    
    
    /*
        [
          [1,2,3],
          [1,3,2],
          [2,1,3],
          [2,3,1],
          [3,1,2],
          [3,2,1]
        ]
                    顺序正确
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        permute(ans, nums, visited, new LinkedList<Integer>());
        return ans;
    }

    private void permute(List<List<Integer>> ans, int[] nums, boolean[] visited, LinkedList<Integer> linkedList) {
        if (linkedList.size() == nums.length) {
            ans.add(new LinkedList<>(linkedList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    linkedList.add(nums[i]);
                    permute(ans, nums, visited, linkedList);
                    linkedList.remove(linkedList.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }
    
/*
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,2,1],
      [3,1,2]
    ]
            顺序不正确
*/
/*

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permute(list, nums, 0);
        return list;
    }

    public void permute(List<List<Integer>> list, int[] nums, int begin) {
        if (begin == nums.length - 1) {
            List<Integer> tmp = new ArrayList<>();
            for (int i : nums) {
                tmp.add(i);
            }
            list.add(tmp);
        } else {
            for (int i = begin; i <= nums.length - 1; i++) {
                swap(nums, begin, i);
                permute(list, nums, begin + 1);
                swap(nums, begin, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

*/

    @Test
    public void testCase() {
        int[] nums = { 1, 2, 3 };
        System.out.println(permute(nums));
    }
}
