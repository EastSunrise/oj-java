package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 86. Partition List (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/partition-list/">Partition List</a>
 * @since 2021-07-11
 */
public class Solution86 implements Solution {

    /**
     * Partitions it node by node.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(0), larger = new ListNode(0);
        ListNode p = head, sp = smaller, lp = larger;
        while (p != null) {
            if (p.val < x) {
                sp.next = p;
                sp = sp.next;
            } else {
                lp.next = p;
                lp = lp.next;
            }
            p = p.next;
        }
        lp.next = null;
        sp.next = larger.next;
        return smaller.next;
    }
}
