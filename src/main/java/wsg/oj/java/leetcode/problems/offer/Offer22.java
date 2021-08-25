package wsg.oj.java.leetcode.problems.offer;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点 LCOF (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/">链表中倒数第k个节点
 * LCOF</a>
 * @since 2021-07-28
 */
public class Offer22 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head;
        while (k-- > 0) {
            p = p.next;
        }
        ListNode q = head;
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        return q;
    }
}
