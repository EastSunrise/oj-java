package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.ListNode;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 82. Remove Duplicates from Sorted List II (Medium)
 *
 * @author Kingen
 * @see Solution83
 * @see Solution1836
 * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/">Remove
 * Duplicates from Sorted List II</a>
 */
public class Solution82 implements Solution {

    /**
     * Deletes node by node.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
