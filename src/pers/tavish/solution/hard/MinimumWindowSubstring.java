package pers.tavish.solution.hard;

/*

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

Note:

    - If there is no such window in S that covers all characters in T, return the empty string "".
    - If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

for more information: https://leetcode.com/problems/minimum-window-substring/description/
*/

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int map[] = new int[128];

        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
        int begin = 0, end = 0, head = 0, d = Integer.MAX_VALUE, counter = t.length();

        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) {
                counter--;
            }
            while (counter == 0) {
                if (d > end - begin) {
                    head = begin;
                    d = end - begin;
                }
                if (map[s.charAt(begin++)]++ == 0) {
                    counter++;
                }
            }
        }
        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }
}
