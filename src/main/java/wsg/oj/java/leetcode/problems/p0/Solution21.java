package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 21. Merge Two Sorted Lists (Easy)
 *
 * @author Kingen
 * @see Solution23
 * @see Solution88
 * @see Solution148
 * @see Solution244
 * @see Solution1634
 * @see <a href="https://leetcode-cn.com/problems/merge-two-sorted-lists/">Merge Two Sorted
 * Lists</a>
 * @since 2021-07-10
 */
public class Solution21 implements Solution {

    /**
     * Traverses the two lists and merges them.
     *
     * @see wsg.oj.java.Complexity#TIME_M_PLUS_N
     * @see wsg.oj.java.Complexity#SPACE_M_PLUS_N
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 == null) {
            l1 = l2;
        }
        while (l1 != null) {
            cur.next = new ListNode(l1.val);
            l1 = l1.next;
            cur = cur.next;
        }
        return result.next;
    }
}
