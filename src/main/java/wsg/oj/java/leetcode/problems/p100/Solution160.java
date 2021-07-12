package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 160. Intersection of Two Linked Lists (Easy)
 *
 * @author Kingen
 * @see Solution599
 * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-linked-lists/">Intersection of
 * Two Linked Lists</a>
 * @since 2021-07-12
 */
class Solution160 implements Solution {

    /**
     * Concatenates the head of one list with the tail of the other list to find a cycle.
     *
     * @complexity T=O(m+n-c), c=length of the intersected part
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cursorA = headA, cursorB = headB;
        while (cursorA != cursorB) {
            cursorA = cursorA == null ? headB : cursorA.next;
            cursorB = cursorB == null ? headA : cursorB.next;
        }
        return cursorA;
    }
}
