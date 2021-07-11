package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 61. Rotate List (Medium)
 *
 * @author Kingen
 * @see Solution189
 * @see Solution725
 * @see <a href="https://leetcode-cn.com/problems/rotate-list/">Rotate List</a>
 * @since 2021-07-11
 */
class Solution61 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int size = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }
        k = size - k % size;
        // concat the head and tail as a circle
        tail.next = head;
        while (k-- > 0) {
            tail = head;
            head = head.next;
        }
        // cut at kth node
        tail.next = null;
        return head;
    }
}
