package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 83. Remove Duplicates from Sorted List (Easy)
 *
 * @author Kingen
 * @see Solution82
 * @see Solution1836
 * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/">Remove
 * Duplicates from Sorted List</a>
 * @since 2021-07-11
 */
class Solution83 implements Solution {

    /**
     * Deletes node by node.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode last = head;
        ListNode cursor = head.next;
        while (cursor != null) {
            if (cursor.val == last.val) {
                last.next = cursor.next;
            } else {
                last = cursor;
            }
            cursor = cursor.next;
        }
        return head;
    }
}
