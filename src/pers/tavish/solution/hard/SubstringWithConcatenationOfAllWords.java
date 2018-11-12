package pers.tavish.solution.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/*

You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

Example 1:
Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.

Example 2:
Input:
  s = "wordgoodstudentgoodword",
  words = ["word","student"]
Output: []

for more information: https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
*/

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        
        if (s.isEmpty() || words.length == 0) {
            return new ArrayList<>();
        }
        
        Map<String, Integer> map = new HashMap<>();
        int lens = s.length(), lenw = words[0].length();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= lens - lenw * words.length; i++) {
            Map<String, Integer> tmp = new HashMap<>();
            int j = 0;
            for (; j < words.length; j++) {
                int pos = i + j * lenw;
                String sub = s.substring(pos, pos + lenw);
                if (map.containsKey(sub)) {
                    int num = 0;
                    if (tmp.containsKey(sub)) {
                        num = tmp.get(sub);
                    }
                    if (map.get(sub) < num + 1) {
                        break;
                    }
                    else {
                        tmp.put(sub, num + 1);
                    }
                } else {
                    break;
                }
            }
            if (j == words.length) {
                res.add(i);
            }
        }
        return res;
    }

    @Test
    public void testCase() {
        String string = "aaa";
        String[] arr = { "a", "a" };
        List<Integer> list = findSubstring(string, arr);
        System.out.println(list);
    }
}
