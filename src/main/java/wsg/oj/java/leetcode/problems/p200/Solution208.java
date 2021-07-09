package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 208. Implement Trie (Prefix Tree) (Medium)
 *
 * @author Kingen
 * @see Solution211
 * @see Solution642
 * @see Solution648
 * @see Solution676
 * @see Solution1804
 * @see <a href="https://leetcode-cn.com/problems/implement-trie-prefix-tree/">Implement Trie
 * (Prefix Tree)</a>
 * @since 2021-06-25
 */
class Solution208 implements Solution {

    static class Trie {

        private final TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            this.root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = this.root;
            for (char ch : word.toCharArray()) {
                int i = ch - 'a';
                if (node.next[i] == null) {
                    node.next[i] = new TrieNode();
                }
                node = node.next[i];
            }
            node.end = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = root;
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
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                int i = ch - 'a';
                if (node.next[i] == null) {
                    return false;
                }
                node = node.next[i];
            }
            return true;
        }

        private static class TrieNode {

            boolean end = false;
            TrieNode[] next = new TrieNode[26];
        }
    }
}
