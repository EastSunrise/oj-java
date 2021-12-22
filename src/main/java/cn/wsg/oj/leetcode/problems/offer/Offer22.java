package cn.wsg.oj.leetcode.problems.offer;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.ListNode;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点 LCOF (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/">链表中倒数第k个节点
 * LCOF</a>
 */
public class Offer22 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
