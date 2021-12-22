package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.ListNode;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p500.Solution599;

/**
 * 160. Intersection of Two Linked Lists (Easy)
 *
 * @author Kingen
 * @see Solution599
 * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-linked-lists/">Intersection of
 * Two Linked Lists</a>
 */
public class Solution160 implements Solution {

    /**
     * Concatenates the head of one list with the tail of the other list to find a cycle.
     *
     * @complexity T=O(m+n-c), c=length of the intersected part
     * @see Complexity#SPACE_CONSTANT
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
