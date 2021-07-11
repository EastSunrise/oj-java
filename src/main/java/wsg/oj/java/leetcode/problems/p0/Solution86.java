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
class Solution86 implements Solution {

    /**
     * Partitions it node by node.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(0), rightHead = new ListNode(0);
        ListNode left = leftHead, right = rightHead;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        right.next = null;
        if (leftHead.next == null) {
            return rightHead.next;
        }
        left.next = rightHead.next;
        return leftHead.next;
    }
}
