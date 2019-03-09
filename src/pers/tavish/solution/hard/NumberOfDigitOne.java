package pers.tavish.solution.hard;

/*

Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

Example:
Input: 13
Output: 6 

Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

for more information: https://leetcode.com/problems/number-of-digit-one/
*/

public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        int res = 0;
        for (long k = 1; k <= n; k *= 10) {
            long r = n / k, m = n % k;
            res += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
        }
        return res;
    }
}
