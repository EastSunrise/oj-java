package wsg.oj.java.leetcode.problems.offer;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 剑指 Offer 6. 从尾到头打印链表 LCOF (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/">从尾到头打印链表
 * LCOF</a>
 * @since 2021-07-28
 */
public class Offer6 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        int[] res = new int[count];
        cur = head;
        while (cur != null) {
            res[--count] = cur.val;
            cur = cur.next;
        }
        return res;
    }
}
