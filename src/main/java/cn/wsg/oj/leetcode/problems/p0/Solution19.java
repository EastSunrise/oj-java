package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.ListNode;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p1700.Solution1721;

/**
 * 19. Remove Nth Node From End of List (Medium)
 *
 * @author Kingen
 * @see Solution1721
 * @see Solution1474
 * @see <a href="https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/">Remove Nth Node
 * From End of List</a>
 */
public class Solution19 implements Solution {

    /**
     * Finds the nth node with two pointers and removes it.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // faster node is n steps faster than the slower one
        ListNode fast = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null) {
            assert head != null;
            return head.next;
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
