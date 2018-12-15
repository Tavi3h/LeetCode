package pers.tavish.solution.hard;

import java.util.Arrays;

import org.junit.Test;

/*

Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example 1:
Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:

As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^

Example 2:
Input: S = "babgbag", T = "bag"
Output: 5
Explanation:

As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^
for more information: https://leetcode.com/problems/distinct-subsequences/description/
*/

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= t.length(); i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                dp[i][j] = s.charAt(i - 1) == t.charAt(j - 1) ? dp[i - 1][j] + dp[i - 1][j - 1] : dp[i - 1][j];
            }
        }
       
        System.out.print("   ");
        for (int i = 0; i < dp[0].length; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int i = 0; i < dp.length; i++) {
            System.out.println(i + " " + Arrays.toString(dp[i]));
        }
        
        return dp[s.length()][t.length()];
    }

    @Test
    public void testCase() {
        String s = "rabbbit", t = "rabbit";
        numDistinct(s, t);
    }
}
