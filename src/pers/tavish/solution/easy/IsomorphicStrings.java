package pers.tavish.solution.easy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*

Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true

Example 2:
Input: s = "foo", t = "bar"
Output: false

Example 3:
Input: s = "paper", t = "title"
Output: true

Note:
You may assume both s and t have the same length.

for more information: https://leetcode.com/problems/isomorphic-strings/
*/

public class IsomorphicStrings {
    
    public boolean isIsomorphic(String s, String t) {
        int[] hashS = new int[256], hashT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char si = s.charAt(i), ti = t.charAt(i);
            if (hashS[si] != hashT[ti]) {
                return false;
            }
            hashS[si] = i + 1;
            hashT[ti] = i + 1;
        }
        return true;
    }
    
//    public boolean isIsomorphic(String s, String t) {
//        Map<Character, Character> map = new HashMap<>();
//        char[] sChars = s.toCharArray(), tChars = t.toCharArray();
//        for (int i = 0; i < sChars.length; i++) {
//            if (map.containsKey(sChars[i])) {
//                if (map.get(sChars[i]) != tChars[i]) {
//                    return false;
//                }
//            } else {
//                for (char c : map.values()) {
//                    if (c == tChars[i]) {
//                        return false;
//                    }
//                }
//                map.put(sChars[i], tChars[i]);
//            }
//        }
//        return true;
//    }

    @Test
    public void testCase() {
        assertEquals(false, isIsomorphic("foo", "bar"));
        assertEquals(true, isIsomorphic("egg", "add"));
        assertEquals(true, isIsomorphic("paper", "title"));
        assertEquals(false, isIsomorphic("ab", "aa"));
        assertEquals(false, isIsomorphic("abcc", "bada"));
    }
}
