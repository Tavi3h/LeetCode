package pers.tavish.solution.hard;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import org.junit.Test;

/*

Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:
Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:
Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23

Note:

    - You may assume that the given expression is always valid.
    - Do not use the eval built-in library function.

for more information: https://leetcode.com/problems/basic-calculator/
*/

public class BasicCalculator {
    public int calculate(String s) {
        int res = 0, sign = 1;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0') {
                int num = 0;
                while (i < s.length() && s.charAt(i) >= '0') {
                    num = 10 * num + s.charAt(i++) - '0';
                }
                res += sign * num;
                --i;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res *= stack.pop();
                res += stack.pop();
            }
        }
        return res;
    }

    @Test
    public void testCase() {
        assertEquals(23, calculate("(1+(4+5+2)-3)+(6+8)"));
        assertEquals(2, calculate("1 + 1"));
        assertEquals(3, calculate("5 -3 +1"));
        assertEquals(7, calculate("5 +3 -1"));
        assertEquals(-15, calculate("2-4-(8+2-6+(8+4-(1)+8-10))"));
    }
}
