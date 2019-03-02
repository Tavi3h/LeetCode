package pers.tavish.solution.medium;

/*

208. Implement Trie (Prefix Tree)

Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true

Note:

    - You may assume that all inputs are consist of lowercase letters a-z.
    - All inputs are guaranteed to be non-empty strings.

for more information: https://leetcode.com/problems/implement-trie-prefix-tree/
*/

public class Trie {

    public static class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode tmp = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (tmp.children[idx] == null) {
                tmp.children[idx] = new TrieNode();
            }
            tmp = tmp.children[idx];
        }
        tmp.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode tmp = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (tmp.children[idx] == null) {
                return false;
            }
            tmp = tmp.children[idx];
        }
        return tmp.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (tmp.children[idx] == null) {
                return false;
            }
            tmp = tmp.children[idx];
        }
        return true;
    }
}
