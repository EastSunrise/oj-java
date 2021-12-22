package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.ListNode;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 143. Reorder List (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/reorder-list/">Reorder List</a>
 */
public class Solution143 implements Solution {

    /**
     * Finds the middle of the list with two pointers, reverses the right half list and merges it
     * with the left half.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
