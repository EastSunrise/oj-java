package wsg.oj.java.leetcode.problems.impl;

import wsg.oj.java.leetcode.problems.AutocompleteSystem;
import wsg.oj.java.leetcode.problems.MagicDictionary;
import wsg.oj.java.leetcode.problems.Solution601;

/**
 * 208. Implement Trie (Prefix Tree) (Medium)
 *
 * @author Kingen
 * @see WordDictionary
 * @see AutocompleteSystem
 * @see Solution601#replaceWords(String[], String)
 * @see MagicDictionary
 * @see Trie
 * @see <a href="https://leetcode-cn.com/problems/implement-trie-prefix-tree/">Implement Trie
 * (Prefix Tree)</a>
 * @since 2021-06-25
 */
public class Trie {

    private final Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node node = this.root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (node.next[i] == null) {
                node.next[i] = new Node();
            }
            node = node.next[i];
        }
        node.end = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (node.next[i] == null) {
                return false;
            }
            node = node.next[i];
        }
        return node.end;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node node = root;
        for (char ch : prefix.toCharArray()) {
            int i = ch - 'a';
            if (node.next[i] == null) {
                return false;
            }
            node = node.next[i];
        }
        return true;
    }

    static class Node {

        boolean end = false;
        Node[] next = new Node[26];
    }
}
