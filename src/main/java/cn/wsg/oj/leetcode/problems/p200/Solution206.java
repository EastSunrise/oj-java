package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.ListNode;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution92;

/**
 * 206. Reverse Linked List (Easy)
 *
 * @author Kingen
 * @see Solution92
 * @see Solution234
 * @see <a href="https://leetcode-cn.com/problems/reverse-linked-list/">Reverse Linked List</a>
 */
public class Solution206 implements Solution {

    /**
     * Reverses the list node by node.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public ListNode reverseList(ListNode head) {
        ListNode dest = null, cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = dest;
            dest = cur;
            cur = next;
        }
        return dest;
    }
}
