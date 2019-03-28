package pers.tavish.solution.medium;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*

Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1:
Input: "2-1-1"
Output: [0, 2]
Explanation: 
((2-1)-1) = 0 
(2-(1-1)) = 2

Example 2:
Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation: 
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10

for more information: https://leetcode.com/problems/different-ways-to-add-parentheses/description/
*/

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> ops = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            int j = i;
            while (j < input.length() && Character.isDigit(input.charAt(j))) {
                ++j;
            }
            ops.add(input.substring(i, j));
            if (j != input.length()) {
                ops.add(input.substring(j, j + 1));
            }
            i = j;
        }
        return calculate(ops, 0, ops.size() - 1);
    }

    private List<Integer> calculate(List<String> ops, int lo, int hi) {
        List<Integer> res = new ArrayList<>();
        if (lo == hi) {
            res.add(Integer.parseInt(ops.get(lo)));
            return res;
        } else {
            for (int i = lo + 1; i < hi; i += 2) {
                String op = ops.get(i);
                List<Integer> left = calculate(ops, lo, i - 1), right = calculate(ops, i + 1, hi);
                for (int leftNum : left) {
                    for (int rightNum : right) {
                        switch (op) {
                        case "+":
                            res.add(leftNum + rightNum);
                            break;
                        case "-":
                            res.add(leftNum - rightNum);
                            break;
                        default:
                            res.add(leftNum * rightNum);
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
    
    @Test
    public void testCase() {
        System.out.println(diffWaysToCompute("1+2*3+4"));
    }
}
