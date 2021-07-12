package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 147. Insertion Sort List (Medium)
 *
 * @author Kingen
 * @see Solution148
 * @see Solution708
 * @see <a href="https://leetcode-cn.com/problems/insertion-sort-list/">Insertion Sort List</a>
 * @since 2021-07-12
 */
class Solution147 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_NN
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(0, head);
        ListNode prev = head, cur = prev.next;
        while (cur != null) {
            prev.next = null;
            ListNode node = res;
            while (node.next != null && node.next.val < cur.val) {
                node = node.next;
            }
            if (node == prev) {
                prev.next = cur;
                prev = cur;
            } else {
                prev.next = cur.next;
                cur.next = node.next;
                node.next = cur;
            }
            cur = prev.next;
        }
        return res.next;
    }
}
