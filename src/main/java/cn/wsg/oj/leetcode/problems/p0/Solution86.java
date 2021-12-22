package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.ListNode;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 86. Partition List (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/partition-list/">Partition List</a>
 */
public class Solution86 implements Solution {

    /**
     * Partitions it node by node.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
