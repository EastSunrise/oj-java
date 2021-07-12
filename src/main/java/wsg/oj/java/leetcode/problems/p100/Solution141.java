package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 141. Linked List Cycle (Easy)
 *
 * @author Kingen
 * @see Solution142
 * @see Solution202
 * @see <a href="https://leetcode-cn.com/problems/linked-list-cycle/">Linked List Cycle</a>
 * @since 2021-07-12
 */
class Solution141 implements Solution {

    /**
     * Uses a faster pointer and a slower pointer.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
