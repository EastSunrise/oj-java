package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.datastructure.TrieNode;
import cn.wsg.oj.datastructure.TrieOpt;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.function.Function;

/**
 * 211. Design Add and Search Words Data Structure (Medium)
 *
 * @author Kingen
 * @see Solution208
 * @see Solution745
 * @see <a href="https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/">Design
 * Add and Search Words Data Structure</a>
 */
public class Solution211 extends Solution208 implements Solution {

    public static class WordDictionary {

        private final int size = 26;
        private final Function<Character, Integer> keyExtractor = ch -> ch - 'a';
        private final TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            this.root = TrieOpt.create(new ArrayList<>(), keyExtractor, size);
        }

        public void addWord(String word) {
            TrieOpt.insert(root, word, keyExtractor, size);
        }

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
