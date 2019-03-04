package pers.tavish.solution.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/*

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]

Note:

    - You may assume that all inputs are consist of lowercase letters a-z.

for more information: https://leetcode.com/problems/word-search-ii/
*/

public class WordSearchII {
    
    // DFS with Trie(array) 20ms
    private class Trie {
        
        Trie[] children;
        boolean isWord;

        Trie() {
            children = new Trie[26];
        }

        void add(String word) {
            Trie trie = this;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (trie.children[idx] == null) {
                    trie.children[idx] = new Trie();
                }
                trie = trie.children[idx];
            }
            trie.isWord = true;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {

        Trie root = new Trie();
        for (String s : words) {
            root.add(s);
        }

        Set<String> res = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] isVisited = new boolean[board.length][board[0].length];
                dfs(board, isVisited, root, res, i, j, "");
            }
        }

        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, boolean[][] isVisited, Trie trie, Set<String> res, int i, int j, String str) {
        if (trie.isWord) {
            res.add(str);
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || isVisited[i][j]
                || trie.children[board[i][j] - 'a'] == null) {
            return;
        }

        isVisited[i][j] = true;
        Trie t = trie.children[board[i][j] - 'a'];
        str += board[i][j];
        dfs(board, isVisited, t, res, i - 1, j, str); // ⬆
        dfs(board, isVisited, t, res, i, j - 1, str); // ←
        dfs(board, isVisited, t, res, i + 1, j, str); // ⬇
        dfs(board, isVisited, t, res, i, j + 1, str); // →
        isVisited[i][j] = false;
    }
    
    @Test
    public void testCase() {

        String[] words = { "oath", "pea", "eat", "rain" };
        char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' } };
        System.out.println(findWords(board, words));
    }
    
    // DFS with Trie (HashMap) 40+ms
//    private class Trie {
//        
//        Map<Character, Trie> children;
//        boolean isWord;
//        Trie() {
//            children = new HashMap<>();
//        }
//        
//        void add(String word) {
//            Trie node = this;
//            for (char c : word.toCharArray()) {
//                Trie child = node.children.getOrDefault(c, new Trie());
//                if (!node.children.containsKey(c)) {
//                    node.children.put(c, child);
//                }
//                node = child;
//            }
//            node.isWord = true;
//        }
//    }
//    
//    public List<String> findWords(char[][] board, String[] words) {
//        
//        Trie root = new Trie();
//        for (String s : words) {
//            root.add(s);
//        }
//        
//        Set<String> res = new HashSet<>();
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                boolean[][] isVisited = new boolean[board.length][board[0].length];
//                dfs(board, isVisited, root, res, i, j, "");
//            }
//        }
//        
//        return new ArrayList<>(res);
//    }
//
//    private void dfs(char[][] board, boolean[][] isVisited, Trie trie, Set<String> res, int i, int j, String str) {
//        
//        if (trie.isWord) {
//            res.add(str);
//        }
//        
//        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || isVisited[i][j] || !trie.children.containsKey(board[i][j])) {
//            return;
//        }
//        
//        isVisited[i][j] = true;
//        Trie t = trie.children.get(board[i][j]);
//        str += board[i][j];
//        dfs(board, isVisited, t, res, i - 1, j, str); // ⬆
//        dfs(board, isVisited, t, res, i, j - 1, str); // ←
//        dfs(board, isVisited, t, res, i + 1, j, str); // ⬇
//        dfs(board, isVisited, t, res, i, j + 1, str); // →
//        isVisited[i][j] = false;
//    }
    
    // Simple DFS 300+ms
//    public List<String> findWords(char[][] board, String[] words) {
//        
//        int m = board.length, n = board[0].length;
//        
//        List<String> res = new ArrayList<>();
//        
//        if (m != 0 && n != 0) {
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    for (String word : words) {
//                        if (!res.contains(word) && search(board, word, i, j, 0)) {
//                            res.add(word);
//                        }
//                    }
//                }
//            }
//        }
//        
//        return res;
//        
//    }
//
//    private boolean search(char[][] board, String word, int i, int j, int idx) {
//        
//        if (idx == word.length()) {
//            return true;
//        }
//        
//        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx)) {
//            return false;
//        }
//        
//        char c = board[i][j];
//        board[i][j] = '$';
//        boolean res = search(board, word, i - 1, j, idx + 1) 
//                       || search(board, word, i + 1, j, idx + 1)
//                       || search(board, word, i, j - 1, idx + 1) 
//                       || search(board, word, i, j + 1, idx + 1);
//        board[i][j] = c;
//        return res;
//    }
}
