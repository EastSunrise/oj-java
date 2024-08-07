package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list-ii/">92. Reverse Linked List II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution206
 */
@Question(
        tags = {Tag.LINKED_LIST},
        difficulty = Difficulty.MEDIUM
)
public class Solution92 {

    @Complexity(time = "O(n)", space = "O(1)")
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode prevTail = dummy;
        while (left-- > 1) {
            prevTail = prevTail.next;
            right--;
        }
        ListNode t = prevTail.next;
        while (right-- > 1) {
            t = t.next;
        }

        ListNode nextHead = t.next, mid = t.next, tmp;
        t = prevTail.next;
        while (t != nextHead) {
            tmp = t.next;
            t.next = mid;
            mid = t;
            t = tmp;
        }
        prevTail.next = mid;
        return dummy.next;
    }
}