package pers.tavish.solution.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/*

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

Example 1:
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Example 2:
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

for more information: https://leetcode.com/problems/word-ladder/
*/

// BFS
public class WordLadder {
/*
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return steps + 1;
                }
                Iterator<String> iter = wordList.iterator();
                while (iter.hasNext()) {
                    String word = iter.next();
                    if (canTransform(curr, word)) {
                        iter.remove();
                        queue.add(word);
                    }
                }
            }
            ++steps;
        }
        return 0;
    }

    private boolean canTransform(String word1, String word2) {
        for (int i = 0, count = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i) && ++count > 1) {
                return false;
            }
        }
        return true;
    }
*/
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList); // Set is faster. If we simply use wordList in this method, we'll get TLE.
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int dist = 1;

        while (!visited.contains(endWord)) {
            Set<String> tmp = new HashSet<>();
            for (String word : visited) {
                for (int i = 0; i < word.length(); ++i) {
                    char[] chars = word.toCharArray();
                    for (char j = 'a'; j < 'z' + 1; ++j) {
                        chars[i] = j;
                        String newWord = new String(chars);
                        if (wordSet.contains(newWord)) {  
                            tmp.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                }
            }
            ++dist;
            if (tmp.isEmpty()) {
                return 0;
            }
            visited = tmp;
        }
        return dist;
    }
    
    @Test
    public void testCase() {
        String beginWord = "hot";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("dot", "cot", "lot", "log", "dog", "cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}
