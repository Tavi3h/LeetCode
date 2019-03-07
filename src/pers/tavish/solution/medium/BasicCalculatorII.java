package pers.tavish.solution.medium;

import java.util.LinkedList;

/*

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:
Input: "3+2*2"
Output: 7

Example 2:
Input: " 3/2 "
Output: 1

Example 3:
Input: " 3+5 / 2 "
Output: 5

Note:
    - You may assume that the given expression is always valid.
    - Do not use the eval built-in library function.

for more information: https://leetcode.com/problems/basic-calculator-ii/
*/

public class BasicCalculatorII {
    public int calculate(String s) {
        int res = 0, num = 0;
        char op = '+';
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0') {
                num = num * 10 + ch - '0';
            } 
            if (i == s.length() - 1 || (ch < '0' && ch != ' ')) {
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else {
                    int tmp = (op == '*') ? stack.pop() * num : stack.pop() / num;
                    stack.push(tmp);
                }
                op = ch;
                num = 0;
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
