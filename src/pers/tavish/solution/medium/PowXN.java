package pers.tavish.solution.medium;

/*

Implement pow(x, n), which calculates x raised to the power n (x^n).

Example 1:
Input: 2.00000, 10
Output: 1024.00000

Example 2:
Input: 2.10000, 3
Output: 9.26100

Example 3:
Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

Note:

-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]

for more information: https://leetcode.com/problems/powx-n/description/
*/

public class PowXN {
    
    public double myPow(double x, int n) {
        return n < 0 ? 1 / power(x, -n) : power(x, n);
    }

    private double power(double x, int n) {

        if (n == 0) {
            return 1;
        }

        double p = power(x, n / 2);

        return n % 2 == 0 ? p * p : p * p * x;
    }
}
