package pers.tavish.solution.easy;

/*

Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:
Input: 4
Output: 2
Example 2:
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.

for more information: https://leetcode.com/problems/sqrtx/description/
*/

public class SqrtX {
    public int mySqrt(int x) {
        double tmp = 1d, err = 0.1;
        while (Math.abs(tmp * tmp - x) > err) {
            tmp = 0.5 * (tmp + x / tmp);
        }
        return (int) Math.floor(tmp);
    }
}
