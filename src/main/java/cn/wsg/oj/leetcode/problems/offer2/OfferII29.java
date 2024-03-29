package cn.wsg.oj.leetcode.problems.offer2;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 剑指 Offer II 29. 排序的循环链表 (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/4ueAj6/">排序的循环链表</a>
 */
public class OfferII29 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        Node p = head;
        do {
            if (p.val <= p.next.val) {
                if (p.val <= insertVal && insertVal <= p.next.val) {
                    break;
                }
            } else {
                if (insertVal <= p.next.val || insertVal > p.val) {
                    break;
                }
            }
            p = p.next;
        } while (p != head);
        p.next = new Node(insertVal, p.next);
        return head;
    }

    /**
     * Definition for a Node.
     */
    static class Node {

        public int val;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
