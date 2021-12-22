package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.ListNode;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 147. Insertion Sort List (Medium)
 *
 * @author Kingen
 * @see Solution148
 * @see Solution708
 * @see <a href="https://leetcode-cn.com/problems/insertion-sort-list/">Insertion Sort List</a>
 */
class Solution147 implements Solution {

    /**
     * @see Complexity#TIME_NN
     * @see Complexity#SPACE_CONSTANT
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
