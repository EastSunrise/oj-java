package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 142. Linked List Cycle II (Medium)
 *
 * @author Kingen
 * @see Solution141
 * @see Solution287
 * @see <a href="https://leetcode-cn.com/problems/linked-list-cycle-ii/">Linked List Cycle II</a>
 * @since 2021-07-12
 */
class Solution142 implements Solution {

    /**
     * Uses a faster pointer and a slower pointer.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
