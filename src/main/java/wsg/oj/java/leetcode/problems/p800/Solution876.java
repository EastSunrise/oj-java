package wsg.oj.java.leetcode.problems.p800;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 876. Middle of the Linked List (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/middle-of-the-linked-list/">Middle of the Linked
 * List</a>
 * @since 2021-07-27
 */
public class Solution876 implements Solution {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
