package pers.tavish.solution.easy;

/*

Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Note:

    - You may assume the string contains only lowercase alphabets.

Follow up:

    - What if the inputs contain unicode characters? How would you adapt your solution to such case?

for more information: https://leetcode.com/problems/valid-anagram/description/
*/

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] hashtable = new int[256];
        for (char c : s.toCharArray()) {
            ++hashtable[c];
        }
        for (char c: t.toCharArray()) {
            --hashtable[c];
        }
        for (int i : hashtable) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
