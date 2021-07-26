package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 143. Reorder List (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/reorder-list/">Reorder List</a>
 * @since 2021-07-12
 */
public class Solution143 implements Solution {

    /**
     * Finds the middle of the list with two pointers, reverses the right half list and merges it
     * with the left half.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        // cut the list at the middle
        slow.next = null;
        // reverse the right half
        ListNode right = null, cur = mid, temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = right;
            right = cur;
            cur = temp;
        }
        // merge the two lists
        ListNode left = head;
        while (right != null) {
            temp = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = temp;
        }
    }
}
