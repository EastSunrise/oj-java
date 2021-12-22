package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.ListNode;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 141. Linked List Cycle (Easy)
 *
 * @author Kingen
 * @see Solution142
 * @see Solution202
 * @see <a href="https://leetcode-cn.com/problems/linked-list-cycle/">Linked List Cycle</a>
 */
public class Solution141 implements Solution {

    /**
     * Uses a faster pointer and a slower pointer.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
