package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution92;

/**
 * 206. Reverse Linked List (Easy)
 *
 * @author Kingen
 * @see Solution92
 * @see Solution156
 * @see Solution234
 * @see <a href="https://leetcode-cn.com/problems/reverse-linked-list/">Reverse Linked List</a>
 * @since 2021-07-12
 */
class Solution206 implements Solution {

    /**
     * Reverses the list node by node.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
