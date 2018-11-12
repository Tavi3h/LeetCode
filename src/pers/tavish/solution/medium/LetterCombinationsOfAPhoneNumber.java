package pers.tavish.solution.medium;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/*

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.

for more information: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
*/

public class LetterCombinationsOfAPhoneNumber {

    // backtracking
    public List<String> letterCombinations(String digits) {
        
        // define table
        String[] table = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> list = new ArrayList<>();
        letterCombinations(list, digits, "", 0, table);
        return list;
    }

    private void letterCombinations(List<String> list, String digits, String curr, int index, String[] table) {
        
        // exit
        if (index == digits.length()) {
            if (curr.length() != 0) {
                list.add(curr);
            }
            return;
        }

        String temp = table[digits.charAt(index) - '0'];
        for (int i = 0; i < temp.length(); i++) {
            letterCombinations(list, digits, curr + temp.charAt(i), index + 1, table);
        }
    }

    @Test
    public void testCase() {
        System.out.println(letterCombinations("23"));
    }
}
