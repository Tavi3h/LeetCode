package pers.tavish.solution.medium;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

for more information: https://leetcode.com/problems/combinations/description/
*/


// dfs
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(result, new ArrayList<Integer>(), n, k, 1);
        return result;
    }

    private void combine(List<List<Integer>> result, List<Integer> arrayList, int n, int k, int level) {
        if (arrayList.size() == k) {
            result.add(new ArrayList<>(arrayList));
        } else {
            for (int i = level; i <= n; i++) {
                arrayList.add(i);
                combine(result, arrayList, n, k, i + 1);
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }

    @Test
    public void testCase() {
        System.out.println(combine(4, 2));
    }
}
