package cn.wsg.oj.leetcode.problems.interview.ch2;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.ListNode;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p100.Solution160;

/**
 * 面试题 2.7. Intersection of Two Linked Lists LCCI (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/">Intersection
 * of Two Linked Lists LCCI</a>
 */
public class Interview7 implements Solution {

    /**
     * @see Solution160
     * @see Complexity#TIME_M_PLUS_N
     * @see Complexity#SPACE_CONSTANT
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
