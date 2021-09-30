package wsg.oj.java.leetcode.problems.p700;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution61;
import wsg.oj.java.leetcode.problems.p300.Solution328;

/**
 * 725. Split Linked List in Parts (MEDIUM)
 *
 * @author Kingen
 * @see Solution61
 * @see Solution328
 * @see <a href="https://leetcode-cn.com/problems/split-linked-list-in-parts/">Split Linked List in
 * Parts</a>
 * @since 2021-07-27
 */
public class Solution725 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode p = head;
        int n = 0;
        while (p != null) {
            n++;
            p = p.next;
        }
        int len = n / k;
        int size = n % k;
        ListNode[] nodes = new ListNode[k];
        p = head;
        for (int i = 0; i < size; i++) {
            nodes[i] = p;
            for (int j = 0; j < len; j++) {
                p = p.next;
            }
            ListNode next = p.next;
            p.next = null;
            p = next;
        }
        if (len == 0) {
            return nodes;
        }
        len--;
        for (int i = size; i < k; i++) {
            nodes[i] = p;
            for (int j = 0; j < len; j++) {
                p = p.next;
            }
            ListNode next = p.next;
            p.next = null;
            p = next;
        }
        return nodes;
    }
}
