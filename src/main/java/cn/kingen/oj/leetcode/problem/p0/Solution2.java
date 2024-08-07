package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/add-two-numbers/">2. Add Two Numbers</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution43
 * @see cn.kingen.oj.leetcode.problem.p0.Solution67
 * @see cn.kingen.oj.leetcode.problem.p300.Solution371
 * @see cn.kingen.oj.leetcode.problem.p400.Solution415
 * @see cn.kingen.oj.leetcode.problem.p400.Solution445
 * @see cn.kingen.oj.leetcode.problem.p900.Solution989
 */
@Question(
        tags = {Tag.RECURSION, Tag.LINKED_LIST, Tag.MATH},
        difficulty = Difficulty.MEDIUM
)
public class Solution2 {

    @Complexity(time = "O(max{m,n})", space = "O(1)")
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), p = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            l1 = l1.next;
            l2 = l2.next;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;
        }
        if (l1 == null) {
            l1 = l2;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            l1 = l1.next;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;
        }
        if (carry == 1) {
            p.next = new ListNode(1);
        }
        return dummy.next;
    }
}