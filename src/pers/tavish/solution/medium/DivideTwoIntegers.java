package pers.tavish.solution.medium;

import org.junit.Test;

/*

Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:
Input: dividend = 10, divisor = 3
Output: 3

Example 2:
Input: dividend = 7, divisor = -3
Output: -2

Note:

    - Both dividend and divisor will be 32-bit signed integers.
    - The divisor will never be 0.
    - Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
    
for more information: https://leetcode.com/problems/divide-two-integers/description/
*/

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {

        if (dividend == -2147483648 && divisor == -1) {
            return 2147483647;
        }

        if (dividend == 0) {
            return 0;
        }

        long a = Math.abs((long) dividend), b = Math.abs((long) divisor);

        if (b > a) {
            return 0;
        }

        long sum = 0;
        int result = 0;

        while (a >= b) {
            int tmp = 1;
            sum = b;
            while (sum + sum <= a) {
                sum += sum;
                tmp += tmp;
            }
            a -= sum;
            result += tmp;
        }
        return (dividend ^ divisor) >>> 31 == 1 ? -result : result;
    }

    @Test
    public void testCase() {
        System.out.println(divide(23, 3));
    }
}
