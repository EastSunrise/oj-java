package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.ListNode;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 83. Remove Duplicates from Sorted List (Easy)
 *
 * @author Kingen
 * @see Solution82
 * @see Solution1836
 * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/">Remove
 * Duplicates from Sorted List</a>
 */
public class Solution83 implements Solution {

    /**
     * Deletes node by node.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = head, cur = head.next;
        while (cur != null) {
            if (cur.val == prev.val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
