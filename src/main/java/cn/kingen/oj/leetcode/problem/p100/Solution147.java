package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/insertion-sort-list/">147. Insertion Sort List</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution148
 * @see cn.kingen.oj.leetcode.problem.p700.Solution708
 */
@Question(
        tags = {Tag.LINKED_LIST, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution147 {

    @Complexity(time = "O(n^2)", space = "O(1)")
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode p = head, cur = head.next, t;
        while (cur != null) {
            int val = cur.val;
            if (p.val <= val) {
                p = cur;
            } else {
                t = dummy;
                while (t.next.val < val) {
                    t = t.next;
                }
                p.next = cur.next;
                cur.next = t.next;
                t.next = cur;
            }
            cur = p.next;
        }
        return dummy.next;
    }
}