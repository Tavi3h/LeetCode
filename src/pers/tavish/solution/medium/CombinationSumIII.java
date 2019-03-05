package pers.tavish.solution.medium;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*

Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

    - All numbers will be positive integers.
    - The solution set must not contain duplicate combinations.

Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]

Example 2:
Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]

for more information: https://leetcode.com/problems/combination-sum-iii/
*/

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<>();

        if (isValid(k, n)) {
            combinationSum3(res, new ArrayList<>(), k, n, 0, 1);
        }

        return res;
    }

    private void combinationSum3(List<List<Integer>> res, List<Integer> list, int k, int n, int sum, int idx) {

        if (sum > n || list.size() > k) {
            return;
        } else if (sum == n && list.size() == k) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = idx; i < 10; i++) {
                list.add(i);
                combinationSum3(res, list, k, n, i + sum, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isValid(int k, int n) {
        int[][] range = { { 0, 0 }, { 1, 9 }, { 3, 17 }, { 6, 24 }, { 10, 30 }, { 15, 35 }, { 21, 39 }, { 28, 42 },
                { 36, 44 }, { 45, 45 } };
        return !(k < 1 || k > 9 || n < 1 || n > 45) && (n >= range[k][0] && n <= range[k][1]);
    }

    @Test
    public void testCase() {
        System.out.println(combinationSum3(4, 13));
    }

}
