package pers.tavish.solution.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/*

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.

Example 1:
Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]

Example 2:
Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:
Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]

for more information: https://leetcode.com/problems/word-break-ii/description/
*/

public class WordBreakII {
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordDict);
        if (wordBreakCheck(s, wordSet)) {
            wordBreak(res, wordSet, s, 0, "");
        }
        return res;
    }

    private void wordBreak(List<String> res, Set<String> wordSet, String s, int start, String cur) {
        if (start == s.length()) {
            res.add(cur.substring(0, cur.length() - 1));
        } else {
            for (int i = start; i < s.length(); i++) {
                String sub = s.substring(start, i + 1);
                if (wordSet.contains(sub)) {
                    wordBreak(res, wordSet, s, i + 1, cur + sub + " ");
                }
            }
        }
    }
    
    private boolean wordBreakCheck(String s, Set<String> wordSet) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
    
    @Test
    public void testCase() {
        String s = "pineapplepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println(wordBreak(s, wordDict));
    }
}
