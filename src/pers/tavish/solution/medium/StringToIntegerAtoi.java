package pers.tavish.solution.medium;

import org.junit.Test;

/*

Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. 
If the numerical value is out of the range of representable values, INT_MAX (2^31 − 1) or INT_MIN (−2^31) is returned.

Example 1:
Input: "42"
Output: 42

Example 2:
Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
             
Example 3:
Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.

Example 4:
Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical 
             digit or a +/- sign. Therefore no valid conversion could be performed.
             
Example 5:
Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Therefore INT_MIN (−2^31) is returned.

for more information: https://leetcode.com/problems/string-to-integer-atoi/description/
*/

public class StringToIntegerAtoi {

    public int myAtoi(String str) {

        if (str == null) {
            return 0;
        }

        String trimString = str.trim();

        if ("".equals(trimString)) {
            return 0;
        }

        String digits = "0123456789";

        String ops = "+-";

        if (trimString.length() == 1) {
            if (digits.contains(trimString)) {
                return Integer.parseInt(trimString);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < trimString.length(); i++) {

            String s = String.valueOf(trimString.charAt(i));

            if (i == 0) {
                if (!digits.contains(s) && !ops.contains(s)) {
                    return 0;
                } else {
                    sb.append(s);
                }
            } else {
                if (digits.contains(s)) {
                    sb.append(s);
                } else {
                    break;
                }
            }
        }

        if (sb.length() == 1 && (sb.charAt(0) == '+' || sb.charAt(0) == '-')) {
            return 0;
        }

        String ans = sb.toString();

        try {
            return Integer.parseInt(ans);
        } catch (Exception e) {
            return ans.contains("-") ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }

    @Test
    public void testCase() {
        System.out.println(myAtoi("2147483648"));
    }
}
