package pers.tavish.solution.medium;

/*

Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note:  

    - 1 is typically treated as an ugly number.
    - n does not exceed 1690.

for more information: https://leetcode.com/problems/ugly-number-ii/description/
*/

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0, idx = 1;
        while (idx < n) {
            res[idx] = Math.min(res[t2] * 2, Math.min(res[t3] * 3, res[t5] * 5));
            t2 += res[idx] == res[t2] * 2 ? 1 : 0;
            t3 += res[idx] == res[t3] * 3 ? 1 : 0;
            t5 += res[idx] == res[t5] * 5 ? 1 : 0;
            ++idx;
        }
        return res[n - 1];
    }
}
