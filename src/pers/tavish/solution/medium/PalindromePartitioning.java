package pers.tavish.solution.medium;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/*

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

for more information: https://leetcode.com/problems/palindrome-partitioning/description/
*/

// backtracking
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        partition(s, 0, new LinkedList<>(), res);
        return res;
    }

    private void partition(String s, int start, List<String> list, List<List<String>> res) {
        if (s.length() == start) {
            res.add(new LinkedList<>(list));
        } else {
            for (int i = start; i < s.length(); ++i) {
                if (isPalindrome(s, start, i)) {
                    list.add(s.substring(start, i + 1));
                    partition(s, i + 1, list, res);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
    
    @Test
    public void testCase() {
        String string = "cddc";
        System.out.println(partition(string));
    }
}
