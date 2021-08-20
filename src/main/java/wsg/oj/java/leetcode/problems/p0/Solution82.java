package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 82. Remove Duplicates from Sorted List II (Medium)
 *
 * @author Kingen
 * @see Solution83
 * @see Solution1836
 * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/">Remove
 * Duplicates from Sorted List II</a>
 * @since 2021-07-11
 */
public class Solution82 implements Solution {

    /**
     * Deletes node by node.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(0, head);
        ListNode cur = head, prev = res;
        while (cur != null) {
            // count of duplicate numbers
            int count = 1, val = cur.val;
            ListNode next = cur.next;
            while (next != null && next.val == val) {
                next = next.next;
                count++;
            }
            if (count > 1) {
                // remove all duplicate nodes
                prev.next = next;
            } else {
                prev = cur;
            }
            cur = next;
        }
        return res.next;
    }
}
