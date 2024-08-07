package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle-ii/">142. Linked List Cycle II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution141
 * @see cn.kingen.oj.leetcode.problem.p200.Solution287
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.LINKED_LIST, Tag.TWO_POINTERS},
        difficulty = Difficulty.MEDIUM
)
public class Solution142 {

    @Complexity(time = "O(n)", space = "O(1)")
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next, fast = head.next.next;
        while (fast != slow && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != slow) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}