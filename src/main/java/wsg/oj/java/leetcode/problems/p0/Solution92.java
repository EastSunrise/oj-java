package wsg.oj.java.leetcode.problems.p0;

import java.util.Stack;
import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 92. Reverse Linked List II (Medium)
 *
 * @author Kingen
 * @see Solution206
 * @see <a href="https://leetcode-cn.com/problems/reverse-linked-list-ii/">Reverse Linked List
 * II</a>
 * @since 2021-07-11
 */
class Solution92 implements Solution {

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
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = pre.next;
        while (right-- > 0) {
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.empty()) {
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
