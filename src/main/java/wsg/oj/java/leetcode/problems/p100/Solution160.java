package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p500.Solution599;

/**
 * 160. Intersection of Two Linked Lists (Easy)
 *
 * @author Kingen
 * @see Solution599
 * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-linked-lists/">Intersection of
 * Two Linked Lists</a>
 * @since 2021-07-12
 */
public class Solution160 implements Solution {

    /**
     * Concatenates the head of one list with the tail of the other list to find a cycle.
     *
     * @complexity T=O(m+n-c), c=length of the intersected part
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }
}
