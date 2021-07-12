package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 211. Design Add and Search Words Data Structure (Medium)
 *
 * @author Kingen
 * @see Solution208
 * @see Solution745
 * @see <a href="https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/">Design
 * Add and Search Words Data Structure</a>
 * @since 2021-06-25
 */
class Solution211 extends Solution208 implements Solution {

    static class WordDictionary extends Trie {

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            super();
        }

        public void addWord(String word) {
            insert(word);
        }

        @Override
        public boolean search(String word) {
            return search(this.root, word.toCharArray(), 0);
        }

        private boolean search(TrieNode node, char[] chars, int i) {
            if (i == chars.length) {
                return node.end;
            }
            char ch = chars[i++];
            if (ch == '.') {
                for (TrieNode child : node.next) {
                    if (child != null && search(child, chars, i)) {
                        return true;
                    }
                }
                return false;
            }
            int idx = ch - 'a';
            return node.next[idx] != null && search(node.next[idx], chars, i);
        }
    }
}
