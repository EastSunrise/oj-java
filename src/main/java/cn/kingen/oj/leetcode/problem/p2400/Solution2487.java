package cn.kingen.oj.leetcode.problem.p2400;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/remove-nodes-from-linked-list/">2487. Remove Nodes From Linked List</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution206
 * @see cn.kingen.oj.leetcode.problem.p200.Solution237
 * @see cn.kingen.oj.leetcode.problem.p400.Solution496
 */
@Question(
        tags = {Tag.STACK, Tag.RECURSION, Tag.LINKED_LIST, Tag.MONOTONIC_STACK},
        difficulty = Difficulty.MEDIUM
)
public class Solution2487 {

    @Complexity(time = "O(n)", space = "O(n)")
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        while (head != null) {
            while (!stack.isEmpty() && head.val > stack.peek().val) {
                stack.pop();
            }
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            ListNode tmp = stack.pop();
            tmp.next = head;
            head = tmp;
        }
        return head;
    }
}