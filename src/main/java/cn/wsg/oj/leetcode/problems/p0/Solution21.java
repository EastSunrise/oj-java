package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.ListNode;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p100.Solution148;

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
 */
public class Solution21 implements Solution {

    /**
     * Traverses the two lists and merges them.
     *
     * @see Complexity#TIME_M_PLUS_N
     * @see Complexity#SPACE_M_PLUS_N
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode prev = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                prev.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 == null) {
            l1 = l2;
        }
        while (l1 != null) {
            prev.next = new ListNode(l1.val);
            l1 = l1.next;
            prev = prev.next;
        }
        return res.next;
    }
}
