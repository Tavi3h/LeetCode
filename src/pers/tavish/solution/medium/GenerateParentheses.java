package pers.tavish.solution.medium;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

for more information: https://leetcode.com/problems/generate-parentheses/description/
*/

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        String curr = "";
        List<String> list = new ArrayList<String>();
        generateParenthesis(list, curr, n, n);
        return list;
    }

    /**
     * 
     * @param list 结果集
     * @param curr 当前生成的字符串
     * @param left 当前剩余左括号的个数
     * @param right 当前剩余右括号的个数
     */
    private void generateParenthesis(List<String> list, String curr, int left, int right) {
        
        // 左右括号均使用完毕，结果集添加结果并退出
        if (left == 0 && right == 0) {
            list.add(curr);
            return;
        }
        // 左括号有剩余
        if (left > 0) {
            // 添加左括号，左括号剩余量减一
            generateParenthesis(list, curr + "(", left - 1, right);
        }
        
        // 左括号的剩余量小于右括号（curr中左括号数量多于右括号）
        if (left < right) {
            generateParenthesis(list, curr + ")", left, right - 1);
        }
    }
    
    @Test
    public void testCase() {
        System.out.println(generateParenthesis(3));
    }
}
