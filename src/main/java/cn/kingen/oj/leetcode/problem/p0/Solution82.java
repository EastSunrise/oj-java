package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/">82. Remove Duplicates from Sorted List II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution83
 */
@Question(
        tags = {Tag.LINKED_LIST, Tag.TWO_POINTERS},
        difficulty = Difficulty.MEDIUM
)
public class Solution82 {

    @Complexity(time = "O(n)", space = "O(1)")
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode p = dummy, t = head;
        while (t != null) {
            // count of duplicate numbers
            int count = 1;
            ListNode next = t.next;
            while (next != null && next.val == t.val) {
                next = next.next;
                count++;
            }
            if (count > 1) {
                // remove all duplicate nodes
                p.next = next;
            } else {
                p = t;
            }
            t = next;
        }
        return dummy.next;
    }
}