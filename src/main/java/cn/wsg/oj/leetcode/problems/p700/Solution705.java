package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p1200.Solution1206;

/**
 * 705. Design HashSet (EASY)
 *
 * @author Kingen
 * @see Solution706
 * @see Solution1206
 * @see <a href="https://leetcode-cn.com/problems/design-hashset/">Design HashSet</a>
 */
public class Solution705 implements Solution {

    static class MyHashSet {

        private final int bucket = 10009;
        private final Node[] table;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            table = new Node[bucket];
        }

        public void add(int key) {
            int hash = hash(key);
            Node node = table[hash];
            while (node != null) {
                if (node.key == key) {
                    return;
                }
                node = node.next;
            }
            table[hash] = new Node(key, table[hash]);
        }

        public void remove(int key) {
            int hash = hash(key);
            Node node = table[hash];
            if (node == null) {
                return;
            }
            if (node.key == key) {
                table[hash] = node.next;
                return;
            }
            Node cur = node.next;
            while (cur != null) {
                if (cur.key == key) {
                    node.next = cur.next;
                    return;
                }
                node = cur;
                cur = cur.next;
            }
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            int hash = hash(key);
            Node node = table[hash];
            while (node != null && node.key != key) {
                node = node.next;
            }
            return node != null;
        }

        private int hash(int key) {
            return (key ^ (key >>> 10)) % bucket;
        }

        private static class Node {

            private final int key;
            private Node next;

            Node(int key, Node next) {
                this.key = key;
                this.next = next;
            }
        }
    }
}
