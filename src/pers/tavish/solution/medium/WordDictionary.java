package pers.tavish.solution.medium;

/*

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true

Note:

    - You may assume that all words are consist of lowercase letters a-z.

for more information: https://leetcode.com/problems/add-and-search-word-data-structure-design/
*/

public class WordDictionary {
    
    private static class TrieNode {
        TrieNode[] children;
        boolean isWord;
        TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root, 0, word);
    }

    private boolean search(TrieNode node, int pos, String word) {
        
        if (pos == word.length() && node.isWord) {
            return true;
        }

        if (pos >= word.length()) {
            return false;
        }

        char ch = word.charAt(pos);
        if (ch == '.') {
            boolean res = false;
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    res |= search(node.children[i], pos + 1, word);
                }
            }
            return res;
        } else {
            int idx = ch - 'a';
            return node.children[idx] != null ? search(node.children[idx], pos + 1, word) : false;
        }
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */