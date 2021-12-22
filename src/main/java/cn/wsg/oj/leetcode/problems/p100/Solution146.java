package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p400.Solution460;
import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache (Medium)
 *
 * @author Kingen
 * @see Solution460
 * @see Solution588
 * @see Solution604
 * @see Solution1756
 * @see <a href="https://leetcode-cn.com/problems/lru-cache/">LRU Cache</a>
 */
public class Solution146 implements Solution {

    static class LRUCache {

        /**
         * the LRU key
         */
        private final DoublyNode head;
        private final DoublyNode tail;
        private final int capacity;
        private final Map<Integer, DoublyNode> nodes;

        public LRUCache(int capacity) {
            this.head = new DoublyNode();
            this.tail = new DoublyNode();
            head.next = tail;
            tail.prev = head;
            this.capacity = capacity;
            nodes = new HashMap<>(capacity);
        }

        public int get(int key) {
            DoublyNode node = nodes.get(key);
            if (node == null) {
                return -1;
            }
            recentlyUsed(node);
            return node.val;
        }

        public void put(int key, int value) {
            DoublyNode old = nodes.get(key);
            if (old != null) {
                // update if exists
                old.val = value;
                recentlyUsed(old);
                return;
            }
            if (nodes.size() == capacity) {
                // remove the LRU key
                nodes.remove(head.next.key);
                head.next = head.next.next;
                head.next.prev = head;
            }
            // add new node and put at the tail
            DoublyNode node = new DoublyNode(key, value);
            nodes.put(key, node);
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
        }

        private void recentlyUsed(DoublyNode node) {
            // move the node to tail
            if (nodes.size() > 1) {
                if (node.next != tail) {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                    node.next = tail;
                    node.prev = tail.prev;
                    tail.prev.next = node;
                    tail.prev = node;
                }
            }
        }

        static class DoublyNode {

            int key;
            int val;
            DoublyNode prev;
            DoublyNode next;

            DoublyNode() {
            }

            DoublyNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}
