package pers.tavish.solution.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/*

Given an array of strings, group anagrams together.

Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

    - All inputs will be in lowercase.
    - The order of your output does not matter.

for more information: https://leetcode.com/problems/group-anagrams/description/
*/

public class GroupAnagrams {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            List<String> list = null;
            String sorted = getSortedString(str);
            if (!map.containsKey(sorted)) {
                list = new ArrayList<>();
                ans.add(list);
            } else {
                list = map.get(sorted);
            }
            list.add(str);
            map.put(sorted, list);
        }
        
        return ans;
    }

    private String getSortedString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    @Test
    public void testCase() {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strs));
    }
}
