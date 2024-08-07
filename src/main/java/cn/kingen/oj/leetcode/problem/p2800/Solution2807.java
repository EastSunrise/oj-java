package cn.kingen.oj.leetcode.problem.p2800;

import cn.kingen.oj.leetcode.support.*;

import static cn.kingen.oj.leetcode.util.MathUtils.gcd;

/**
 * <a href="https://leetcode.cn/problems/insert-greatest-common-divisors-in-linked-list/">2807. Insert Greatest Common Divisors in Linked List</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution206
 */
@Question(
        tags = {Tag.LINKED_LIST, Tag.MATH, Tag.NUMBER_THEORY},
        difficulty = Difficulty.MEDIUM
)
public class Solution2807 {

    @Complexity(time = "O(n*log{MAX_VALUE})", space = "O(1)")
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode node = head;
        while (node.next != null) {
            node.next = new ListNode(gcd(node.val, node.next.val), node.next);
            node = node.next.next;
        }
        return head;
    }
}