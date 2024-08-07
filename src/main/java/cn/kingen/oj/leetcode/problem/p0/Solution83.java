package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list/">83. Remove Duplicates from Sorted List</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution82
 */
@Question(
        tags = {Tag.LINKED_LIST},
        difficulty = Difficulty.EASY
)
public class Solution83 {

    @Complexity(time = "O(n)", space = "O(1)")
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode t = head;
        while (t.next != null) {
            if (t.val == t.next.val) {
                t.next = t.next.next;
            } else {
                t = t.next;
            }
        }
        return head;
    }
}