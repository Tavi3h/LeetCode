package pers.tavish.solution.medium;

import org.junit.Test;

/*

Given an input string, reverse the string word by word.

Example:  

Input: "the sky is blue",
Output: "blue is sky the".
Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
Follow up: For C programmers, try to solve it in-place in O(1) space.

for more information: https://leetcode.com/problems/reverse-words-in-a-string/description/
*/

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        
        if (s == null) {
            return null;
        }
        
        if (s.trim().isEmpty()) {
            return "";
        }
        
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >=0; --i) {
            if (words[i].isEmpty()) {
                continue;
            }
            sb.append(words[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    @Test
    public void testCase() {
        String str = "the sky is blue";
        System.out.println(reverseWords(str));
    }
}
