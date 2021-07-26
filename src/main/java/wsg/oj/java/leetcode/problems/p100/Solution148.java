package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution21;
import wsg.oj.java.leetcode.problems.p0.Solution75;

/**
 * 148. Sort List (Medium)
 *
 * @author Kingen
 * @see Solution21
 * @see Solution75
 * @see Solution147
 * @see <a href="https://leetcode-cn.com/problems/sort-list/">Sort List</a>
 * @since 2021-07-12
 */
public class Solution148 implements Solution {

    /**
     * Quick sorting.
     *
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode(0, head);
        ListNode slow = res;
        for (ListNode fast = res; fast != null && fast.next != null; fast = fast.next.next) {
            slow = slow.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        slow = res;
        while (left != null && right != null) {
            if (left.val > right.val) {
                slow.next = right;
                right = right.next;
            } else {
                slow.next = left;
                left = left.next;
            }
            slow = slow.next;
        }
        if (left != null) {
            slow.next = left;
        }
        if (right != null) {
            slow.next = right;
        }
        return res.next;
    }
}
