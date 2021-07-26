package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 677. Map Sum Pairs (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/map-sum-pairs/">Map Sum Pairs</a>
 * @since 2021-07-23
 */
public class Solution677 implements Solution {

    static class MapSum {

        private final PrefixNode root;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            this.root = new PrefixNode();
        }

        public void insert(String key, int val) {
            PrefixNode cur = root;
            for (char ch : key.toCharArray()) {
                int i = ch - 'a';
                if (cur.next[i] == null) {
                    cur.next[i] = new PrefixNode();
                }
                cur = cur.next[i];
            }
            cur.val = val;
        }

        public int sum(String prefix) {
            PrefixNode cur = root;
            for (char ch : prefix.toCharArray()) {
                int i = ch - 'a';
                if (cur.next[i] == null) {
                    return 0;
                }
                cur = cur.next[i];
            }
            return sum(cur);
        }

        private int sum(PrefixNode node) {
            int sum = node.val;
            for (PrefixNode next : node.next) {
                if (next != null) {
                    sum += sum(next);
                }
            }
            return sum;
        }

        static class PrefixNode {

            private final PrefixNode[] next = new PrefixNode[26];
            private int val = 0;
        }
    }
}
