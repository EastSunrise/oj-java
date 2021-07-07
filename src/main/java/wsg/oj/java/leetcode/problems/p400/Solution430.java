package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 430. Flatten a Multilevel Doubly Linked List (Medium)
 *
 * @author Kingen
 * @see Solution114
 * @see Solution1660
 * @see <a href="https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/">Flatten
 * a Multilevel Doubly Linked List</a>
 * @since 2021-07-07
 */
class Solution430 extends Solution {

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        return headAndTail(head)[0];
    }

    private Node[] headAndTail(Node head) {
        Node cur = head;
        while (true) {
            Node next = cur.next;
            Node child = cur.child;
            if (next == null && child == null) {
                // reach the tail of the linked list
                return new Node[]{head, cur};
            }
            if (child != null) {
                Node[] nodes = headAndTail(child);
                cur.child = null;
                cur.next = nodes[0];
                nodes[0].prev = cur;
                if (next == null) {
                    return new Node[]{head, nodes[1]};
                }
                next.prev = nodes[1];
                nodes[1].next = next;
            }
            cur = next;
        }
    }

    /**
     * Definition for a Node.
     */
    static class Node {

        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
