package pers.tavish.solution.easy;

import org.junit.Test;

/*

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Note:

All given inputs are in lowercase letters a-z.

for more information: https://leetcode.com/problems/longest-common-prefix/description/
*/

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        int minlength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minlength = Math.min(strs[i].length(), minlength);
        }

        String prefix = "";
        Outer: for (int i = 0; i <= strs[0].length(); i++) {
            String tmp = strs[0].substring(0, i);
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(tmp)) {
                    break Outer;
                }
            }
            prefix = tmp;
        }

        return prefix;
    }

    @Test
    public void testCase() {
        String[] strs = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs));
    }
}
