package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/split-linked-list-in-parts/">725. Split Linked List in Parts</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution61
 * @see cn.kingen.oj.leetcode.problem.p300.Solution328
 * @see cn.kingen.oj.leetcode.problem.p2600.Solution2674
 */
@Question(
        tags = {Tag.LINKED_LIST},
        difficulty = Difficulty.MEDIUM
)
public class Solution725 {

    @Complexity(time = "O(n)", space = "O(1)")
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode p = head, t;
        int n = 0;
        while (p != null) {
            n++;
            p = p.next;
        }
        int len = n / k;
        int r = n % k;
        ListNode[] ans = new ListNode[k];

        p = head;
        for (int i = 0; i < r; i++) {
            ans[i] = p;
            for (int j = 0; j < len; j++) {
                p = p.next;
            }
            t = p.next;
            p.next = null;
            p = t;
        }
        if (len == 0) {
            return ans;
        }
        for (int i = r; i < k; i++) {
            ans[i] = p;
            for (int j = 1; j < len; j++) {
                p = p.next;
            }
            ListNode next = p.next;
            p.next = null;
            p = next;
        }
        return ans;
    }
}