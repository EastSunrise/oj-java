package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p100.Solution114;

/**
 * 430. Flatten a Multilevel Doubly Linked List (Medium)
 *
 * @author Kingen
 * @see Solution114
 * @see Solution1660
 * @see <a href="https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/">Flatten
 * a Multilevel Doubly Linked List</a>
 */
public class Solution430 implements Solution {

    /**
     * @see #DFS
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
     */
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        tail(head);
        return head;
    }

    private Node tail(Node head) {
        Node cur = head;
        while (true) {
            Node next = cur.next;
            Node child = cur.child;
            if (next == null && child == null) {
                // reach the tail of the linked list
                return cur;
            }
            if (child != null) {
                Node tail = tail(child);
                cur.child = null;
                cur.next = child;
                child.prev = cur;
                if (next == null) {
                    return tail;
                }
                next.prev = tail;
                tail.next = next;
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
