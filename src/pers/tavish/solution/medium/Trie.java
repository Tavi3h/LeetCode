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

    // with private static inner class
    private static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        TrieNode() {
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
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
        }
        return node.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
        }
        return true;
    }
    
    // without private static inner class
//    private Trie[] children;
//    private boolean isWord;
//
//    /** Initialize your data structure here. */
//    public Trie() {
//        children = new Trie[26];
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        Trie node = this;
//        for (int i = 0; i < word.length(); i++) {
//            int idx = word.charAt(i) - 'a';
//            if (node.children[idx] == null) {
//                node.children[idx] = new Trie();
//            }
//            node = node.children[idx];
//        }
//        node.isWord = true;
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        Trie node = this;
//        for (int i = 0; i < word.length(); i++) {
//            int idx = word.charAt(i) - 'a';
//            if (node.children[idx] == null) {
//                return false;
//            }
//            node = node.children[idx];
//        }
//        return node.isWord;
//    }
//
//    /**
//     * Returns if there is any word in the trie that starts with the given prefix.
//     */
//    public boolean startsWith(String prefix) {
//        Trie node = this;
//        for (int i = 0; i < prefix.length(); i++) {
//            int idx = prefix.charAt(i) - 'a';
//            if (node.children[idx] == null) {
//                return false;
//            }
//            node = node.children[idx];
//        }
//        return true;
//    }
    
}
