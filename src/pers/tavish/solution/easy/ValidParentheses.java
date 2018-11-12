package pers.tavish.solution.easy;

import java.util.LinkedList;

import org.junit.Test;

/*

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:
Input: "()"
Output: true

Example 2:
Input: "()[]{}"
Output: true

Example 3:
Input: "(]"
Output: false

Example 4:
Input: "([)]"
Output: false

Example 5:
Input: "{[]}"
Output: true

for more information: https://leetcode.com/problems/valid-parentheses/description/
*/

public class ValidParentheses {
    
    class Stack<T> {
        private LinkedList<T> linkedList;
        public Stack() {
            linkedList = new LinkedList<>();
        }
        
        public void push(T t) {
            linkedList.addFirst(t);
        }
        
        public T pop() {
            return linkedList.removeFirst();
        }
        
        public boolean isEmpty() {
            return linkedList.isEmpty();
        }
    }
    
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!check(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean check(char c1, char c2) {
        
        if (c1 == '(') {
            return c2 == ')';
        } else if (c1 == '{') {
            return c2 == '}';
        } else {
            return c2 == ']';
        }
    }
    
    @Test
    public void testCase() {
        System.out.println(isValid("{[]}"));
    }
    
}
