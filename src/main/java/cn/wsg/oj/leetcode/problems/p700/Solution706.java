package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p1200.Solution1206;

/**
 * 706. Design HashMap (EASY)
 *
 * @author Kingen
 * @see Solution705
 * @see Solution1206
 * @see <a href="https://leetcode-cn.com/problems/design-hashmap/">Design HashMap</a>
 */
public class Solution706 implements Solution {

    static class MyHashMap {

        private final int bucket = 10009;
        private final Node[] table;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            table = new Node[bucket];
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            int hash = hash(key);
            Node node = table[hash];
            while (node != null) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
                node = node.next;
            }
            table[hash] = new Node(key, value, table[hash]);
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no
         * mapping for the key
         */
        public int get(int key) {
            int hash = hash(key);
            Node node = table[hash];
            while (node != null && node.key != key) {
                node = node.next;
            }
            return node == null ? -1 : node.value;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the
         * key
         */
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

        private int hash(int key) {
            return (key ^ (key >>> 10)) % bucket;
        }

        private static class Node {

            private final int key;
            private int value;
            private Node next;

            Node(int key, int value, Node next) {
                this.key = key;
                this.value = value;
                this.next = next;
            }
        }
    }
}
