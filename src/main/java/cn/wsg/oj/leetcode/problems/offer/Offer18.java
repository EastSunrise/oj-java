package cn.wsg.oj.leetcode.problems.offer;

import cn.wsg.oj.leetcode.problems.base.ListNode;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 剑指 Offer 18. 删除链表的节点 LCOF (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/">删除链表的节点
 * LCOF</a>
 */
public class Offer18 implements Solution {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode root = new ListNode(0, head);
        ListNode p = root;
        while (p.next != null && p.next.val != val) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
        }
        return root.next;
    }
}
