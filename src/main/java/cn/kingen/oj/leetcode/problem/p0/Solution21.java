package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.problem.p200.WordDistance;
import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">21. Merge Two Sorted Lists</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution23
 * @see cn.kingen.oj.leetcode.problem.p0.Solution88
 * @see cn.kingen.oj.leetcode.problem.p100.Solution148
 * @see WordDistance
 */
@Question(
        tags = {Tag.RECURSION, Tag.LINKED_LIST},
        difficulty = Difficulty.EASY
)
public class Solution21 {

    @Complexity(time = "O(m+n)", space = "O(m+n)")
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode prev = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                prev.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 == null) {
            l1 = l2;
        }
        while (l1 != null) {
            prev.next = new ListNode(l1.val);
            l1 = l1.next;
            prev = prev.next;
        }
        return head.next;
    }
}