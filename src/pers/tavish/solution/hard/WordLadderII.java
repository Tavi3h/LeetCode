package pers.tavish.solution.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

/*

Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

Example 1:
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]

Example 2:
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

for more information: https://leetcode.com/problems/word-ladder-ii/description/
*/

public class WordLadderII {
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new LinkedList<>();
        List<String> path = new LinkedList<>();
        Map<String, List<String>> neighborsMap = new HashMap<>();
        Map<String, Integer> dist = new HashMap<>(); 
        
        dict.add(beginWord);
        bfs(beginWord, endWord, dict, neighborsMap, dist);
        
//        System.out.println(neighborsMap);
//        System.out.println(dist);
        
        dfs(beginWord, endWord, dict, neighborsMap, dist, path, res);
        return res;
    }

    private void dfs(String beginWord, String endWord, Set<String> dict, Map<String, List<String>> neighborsMap,
            Map<String, Integer> dist, List<String> path, List<List<String>> res) {
        path.add(beginWord);
        if (beginWord.equals(endWord)) {
            res.add(new LinkedList<>(path));
        } else {
            for (String next : neighborsMap.get(beginWord)) {
                if (dist.get(next) == dist.get(beginWord) + 1) {
                    dfs(next, endWord, dict, neighborsMap, dist, path, res);
                }
            }
        }
        path.remove(path.size() - 1);
//        System.out.println(path);
    }

    private void bfs(String beginWord, String endWord, Set<String> dict, Map<String, List<String>> neighborsMap,
            Map<String, Integer> dist) {

        // init neighbors
        for (String str : dict) {
            neighborsMap.put(str, new LinkedList<>());
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        dist.put(beginWord, 0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < size; ++i) {
                String curr = queue.poll();
                int curDistance = dist.get(curr);
                for (String neighbor : getNeighbors(curr, dict)) {
                    neighborsMap.get(curr).add(neighbor);
                    if (!dist.containsKey(neighbor)) {
                        dist.put(neighbor, curDistance + 1);
                        if (neighbor.equals(endWord)) {
                            foundEnd = true;
                        } else {
                            queue.add(neighbor);
                        }
                    }
                }
            }
            if (foundEnd) {
                break;
            }
        }
//        System.out.println(queue);
    }

    private List<String> getNeighbors(String curr, Set<String> dict) {
        
        List<String> list = new LinkedList<>();
        for (int i = 0; i < curr.length(); ++i) {
            char[] chars = curr.toCharArray();
            char old = chars[i];
            for (char ch = 'a'; ch <= 'z'; ++ch) {
                if (chars[i] == ch) {
                    continue;
                }
                chars[i] = ch;
                String word = new String(chars);
                if (dict.contains(word)) {
                    list.add(word);
                }
                chars[i] = old;
            }
        }
        
        return list;
    }

/*
 * TLE
    private int minLevel = Integer.MAX_VALUE;
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<Integer, List<List<String>>> res = new HashMap<>();
        List<String> list = new LinkedList<>();
        list.add(beginWord);
        findLadders(res, list, new HashSet<>(wordList), endWord, 1);
        return minLevel == Integer.MAX_VALUE ? new LinkedList<>() : res.get(minLevel);
    }

    private void findLadders(Map<Integer, List<List<String>>> res, List<String> list, Set<String> wordSet, String endWord, int currLevel) {
        
        int size = list.size();
        String beginWord = list.get(size - 1);
        if (beginWord.equals(endWord)) {
            if (size <= minLevel) {
                minLevel = size;
                if (res.containsKey(minLevel)) {
                    res.get(minLevel).add(new LinkedList<>(list));
                } else {
                    List<List<String>> tmp = new LinkedList<>();
                    tmp.add(new LinkedList<>(list));
                    res.put(minLevel, tmp);
                }
            }
        } else {
            if (++currLevel > minLevel) {
                return;
            }
            List<String> queue = new LinkedList<>();
            Set<String> tmpSet = new HashSet<>(wordSet);
            for (int i = 0; i < beginWord.length(); ++i) {
                char[] chars = beginWord.toCharArray();
                char old = chars[i];
                for (char j = 'a'; j <= 'z'; ++j) {
                    if (chars[i] == j) {
                        continue;
                    }
                    chars[i] = j;
                    String newWord = new String(chars);
                    if (tmpSet.contains(newWord)) {
                        queue.add(newWord);
                        tmpSet.remove(newWord);
                    }
                    chars[i] = old;
                }
            }
            for (String curr : queue) {
                list.add(curr);
                findLadders(res, list, tmpSet, endWord, currLevel);
                list.remove(list.size() - 1);
            }
        }
    }
 */
    
    @Test
    public void testCase() {
        String beginWord = "hot";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("dot", "cot", "lot", "log", "cog", "dog");
        System.out.println(findLadders(beginWord, endWord, wordList));
    }
}