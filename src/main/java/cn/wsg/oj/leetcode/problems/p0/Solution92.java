package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.leetcode.problems.base.ListNode;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution206;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 92. Reverse Linked List II (Medium)
 *
 * @author Kingen
 * @see Solution206
 * @see <a href="https://leetcode-cn.com/problems/reverse-linked-list-ii/">Reverse Linked List
 * II</a>
 */
public class Solution92 implements Solution {

    /**
     * Uses a stack to store the sublist to be reversed.
     *
     * @complexity T=O(r), r=right
     * @complexity S=O(d), d=right-left
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode(0, head);
        ListNode pre = res;
        while (left-- > 1) {
            pre = pre.next;
            right--;
        }
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = pre.next;
        while (right-- > 0) {
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            ListNode top = stack.pop();
            // cut to prevent a circle
            top.next = null;
            pre.next = top;
            pre = top;
        }
        pre.next = cur;
        return res.next;
    }
}
