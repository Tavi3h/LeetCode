package pers.tavish.solution.medium;

import org.junit.Test;

/*

 The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.

Example 1:
Input: n = 3, k = 3
Output: "213"

Example 2:
Input: n = 4, k = 9
Output: "2314"

for more information: https://leetcode.com/problems/permutation-sequence/description/
*/

public class PermutationSequence {

    public String getPermutation(int n, int k) {
        int i = 0, j = 0;
        boolean[] isUsed = new boolean[n];
        int[] data = new int[n];
        data[0] = 1;
        for (i = 1; i < n; i++) {
            data[i] = data[i - 1] * i;
        }
        --k;
        StringBuilder result = new StringBuilder();
        while (--i >= 0) {
            int rank = k / data[i];
            for (j = 0; j <= rank; j++) {
                if (isUsed[j]) {
                    rank++;
                }
            }
            isUsed[rank] = true;
            result.append(j);
            k = k % data[i];
        }
        return result.toString();
    }

    @Test
    public void testCase() {
        System.out.println(getPermutation(9, 199269));
    }
}
