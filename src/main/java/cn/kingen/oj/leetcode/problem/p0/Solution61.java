package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/rotate-list/">61. Rotate List</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution189
 * @see cn.kingen.oj.leetcode.problem.p700.Solution725
 */
@Question(
        tags = {Tag.LINKED_LIST, Tag.TWO_POINTERS},
        difficulty = Difficulty.MEDIUM
)
public class Solution61 {

    /**
     * Links the head and tail as a circle, then cuts at k-th node.
     */
    @Complexity(time = "O(n+k)", space = "O(1)")
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int size = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }

        k = size - k % size;
        tail.next = head;
        while (k-- > 0) {
            tail = head;
            head = head.next;
        }
        // cut at kth node
        tail.next = null;
        return head;
    }
}