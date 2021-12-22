package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.datastructure.TrieNode;
import cn.wsg.oj.datastructure.TrieOpt;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p600.Solution648;
import cn.wsg.oj.leetcode.problems.p600.Solution676;
import java.util.ArrayList;
import java.util.function.Function;

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
 */
public class Solution208 implements Solution {

    static class Trie {

        private final int size = 26;
        private final Function<Character, Integer> keyExtractor = ch -> ch - 'a';
        private final TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            this.root = TrieOpt.create(new ArrayList<>(), keyExtractor, size);
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieOpt.insert(root, word, keyExtractor, size);
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            return TrieOpt.search(root, word, keyExtractor);
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return TrieOpt.startsWith(root, prefix, keyExtractor);
        }
    }
}
