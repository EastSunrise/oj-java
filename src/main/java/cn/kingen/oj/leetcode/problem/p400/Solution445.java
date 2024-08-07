package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/add-two-numbers-ii/">445. Add Two Numbers II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution2
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1634
 */
@Question(
        tags = {Tag.STACK, Tag.LINKED_LIST, Tag.MATH},
        difficulty = Difficulty.MEDIUM
)
public class Solution445 {

    /**
     * Reverses the linked lists and then add two numbers.
     */
    @Complexity(time = "O(n)", space = "O(n)")
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = null, t2 = null, tmp;
        while (l1 != null) {
            tmp = l1.next;
            l1.next = t1;
            t1 = l1;
            l1 = tmp;
        }
        while (l2 != null) {
            tmp = l2.next;
            l2.next = t2;
            t2 = l2;
            l2 = tmp;
        }

        ListNode ans = null;
        int carry = 0;
        while (t1 != null && t2 != null) {
            int sum = t1.val + t2.val + carry;
            ans = new ListNode(sum % 10, ans);
            carry = sum / 10;
            t1 = t1.next;
            t2 = t2.next;
        }
        if (t1 == null) {
            t1 = t2;
        }
        while (t1 != null) {
            int sum = t1.val + carry;
            ans = new ListNode(sum % 10, ans);
            carry = sum / 10;
            t1 = t1.next;
        }
        return carry == 0 ? ans : new ListNode(carry, ans);
    }
}