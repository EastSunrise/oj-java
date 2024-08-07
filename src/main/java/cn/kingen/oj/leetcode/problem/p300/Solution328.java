package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/odd-even-linked-list/">328. Odd Even Linked List</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p700.Solution725
 */
@Question(
        tags = {Tag.LINKED_LIST},
        difficulty = Difficulty.MEDIUM
)
public class Solution328 {

    @Complexity(time = "O(n)", space = "O(1)")
    public ListNode oddEvenList(ListNode head) {
        ListNode ans = new ListNode(0);
        ListNode dummy = new ListNode(0);
        ListNode t = head, op = ans, ep = dummy;
        while (t != null) {
            op.next = t;
            op = t;
            t = t.next;
            if (t != null) {
                ep.next = t;
                ep = t;
                t = t.next;
            }
        }
        ep.next = null;
        op.next = dummy.next;
        return ans.next;
    }
}