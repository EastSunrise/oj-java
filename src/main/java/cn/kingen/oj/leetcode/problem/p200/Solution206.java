package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list/">206. Reverse Linked List</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution92
 * @see cn.kingen.oj.leetcode.problem.p100.Solution156
 * @see cn.kingen.oj.leetcode.problem.p200.Solution234
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2074
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2130
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2487
 * @see cn.kingen.oj.leetcode.problem.p2800.Solution2807
 */
@Question(
        tags = {Tag.RECURSION, Tag.LINKED_LIST},
        difficulty = Difficulty.EASY
)
public class Solution206 {

    @Complexity(time = "O(n)", space = "O(1)")
    public ListNode reverseList(ListNode head) {
        ListNode ans = null, t = head, next;
        while (t != null) {
            next = t.next;
            t.next = ans;
            ans = t;
            t = next;
        }
        return ans;
    }
}