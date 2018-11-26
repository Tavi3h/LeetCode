package pers.tavish.solution.easy;

import org.junit.Test;

/*

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:
Input: "Hello World"
Output: 5

for more information: https://leetcode.com/problems/length-of-last-word/description/
*/

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        return strings.length == 0 ? 0 : strings[strings.length - 1].length();
    }

    @Test
    public void testCase() {
        System.out.println(lengthOfLastWord("    "));
    }
}
