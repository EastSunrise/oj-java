package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 328. Odd Even Linked List (Medium)
 *
 * @author Kingen
 * @see Solution725
 * @see <a href="https://leetcode-cn.com/problems/odd-even-linked-list/">Odd Even Linked List</a>
 * @since 2021-07-04
 */
class Solution328 implements Solution {

    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0, head);
        ListNode even = new ListNode(0);
        ListNode node = head, oddPrev = odd, evenPrev = even;
        while (node != null) {
            oddPrev.next = node;
            oddPrev = node;
            node = node.next;
            if (node != null) {
                evenPrev.next = node;
                evenPrev = node;
                node = node.next;
            }
        }
        evenPrev.next = null;
        oddPrev.next = even.next;
        return odd.next;
    }
}
