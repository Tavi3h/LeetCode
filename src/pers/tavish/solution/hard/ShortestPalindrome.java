package pers.tavish.solution.hard;

/*

Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

Example 1:
Input: "aacecaaa"
Output: "aaacecaaa"

Example 2:
Input: "abcd"
Output: "dcbabcd"

for more information: https://leetcode.com/problems/shortest-palindrome/
*/

public class ShortestPalindrome {
    
    // KMP
    public String shortestPalindrome(String s) {
        String r = new StringBuilder(s).reverse().toString();
        String t = s + "#" + r;
        int[] next = new int[t.length()];
        for (int i = 1; i < t.length(); ++i) {
            int j = next[i - 1];
            while (j > 0 && t.charAt(i) != t.charAt(j)) {
                j = next[j - 1];
            }
            j += t.charAt(i) == t.charAt(j) ? 1 : 0;
            next[i] = j;
        }
        return r.substring(0, s.length() - next[t.length() - 1]) + s;
    }
    
//    public String shortestPalindrome(String s) {
//        int i = 0, end = s.length() - 1, j = end;
//        char[] arr = s.toCharArray();
//        while (i < j) {
//            if (arr[i] == arr[j]) {
//                ++i;
//                --j;
//            } else {
//                i = 0;
//                j = --end;
//            }
//        }
//        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
//    }
}
