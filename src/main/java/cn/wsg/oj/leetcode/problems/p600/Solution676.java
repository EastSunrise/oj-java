package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.datastructure.TrieNode;
import cn.wsg.oj.datastructure.TrieOpt;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution208;
import cn.wsg.oj.leetcode.problems.p700.Solution720;

/**
 * 676. Implement Magic Dictionary (MEDIUM)
 *
 * @author Kingen
 * @see Solution208
 * @see Solution720
 * @see <a href="https://leetcode-cn.com/problems/implement-magic-dictionary/">Implement Magic
 * Dictionary</a>
 */
public class Solution676 implements Solution {

    static class MagicDictionary extends TrieOpt {

        private final int size = 26;
        private final TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public MagicDictionary() {
            this.root = new TrieNode(size);
        }

        public void buildDict(String[] dictionary) {
            for (String word : dictionary) {
                insert(root, word, ch -> ch - 'a', size);
            }
        }

        public boolean search(String searchWord) {
            TrieNode cur = root;
            int i = 0, n = searchWord.length();
            while (i < n) {
                int idx = searchWord.charAt(i) - 'a';
                // replace this char
                String remaining = searchWord.substring(i + 1);
                for (int j = 0; j < 26; j++) {
                    if (j != idx && cur.next[j] != null) {
                        if (search(cur.next[j], remaining, ch -> ch - 'a')) {
                            return true;
                        }
                    }
                }
                if (cur.next[idx] == null) {
                    return false;
                }
                cur = cur.next[idx];
                i++;
            }
            return false;
        }
    }
}
