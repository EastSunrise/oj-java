package wsg.oj.java.leetcode.problems.p400;

import java.util.Stack;
import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 445. Add Two Numbers II (Medium)
 *
 * @author Kingen
 * @see Solution2
 * @see Solution1634
 * @see <a href="https://leetcode-cn.com/problems/add-two-numbers-ii/">Add Two Numbers II</a>
 * @since 2021-07-08
 */
class Solution445 extends Solution {

    /**
     * Stack.
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode res = null;
        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int sum = stack1.pop() + stack2.pop() + carry;
            res = new ListNode(sum % 10, res);
            carry = sum / 10;
        }
        if (stack1.isEmpty()) {
            stack1 = stack2;
        }
        while (!stack1.isEmpty()) {
            int sum = stack1.pop() + carry;
            res = new ListNode(sum % 10, res);
            carry = sum / 10;
        }
        return carry == 0 ? res : new ListNode(carry, res);
    }

    /**
     * Recursion.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1.next, node2 = l2.next;
        while (node1 != null && node2 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        ListNode res = new ListNode();
        if (node1 == null && node2 == null) {
            int carry = addNode(res, l1, l2);
            if (carry == 0) {
                return res.next;
            }
            res.val = carry;
            return res;
        }
        if (node1 == null) {
            node1 = l2;
            l2 = l1;
            l1 = node1;
            node1 = node2;
        }
        node2 = l1;
        while (node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        int carry = addNode(res, node2.next, l2);
        // cut at the same length
        node2.next = null;
        carry = addCarry(res, l1, carry);
        if (carry == 0) {
            return res.next;
        }
        res.val = carry;
        return res;
    }

    private int addNode(ListNode res, ListNode node1, ListNode node2) {
        res.next = new ListNode();
        int sum = node1.val + node2.val;
        if (node1.next != null) {
            sum += addNode(res.next, node1.next, node2.next);
        }
        res.next.val = sum % 10;
        return sum / 10;
    }

    private int addCarry(ListNode res, ListNode node, int carry) {
        res.next = new ListNode(0, res.next);
        if (node.next != null) {
            carry = addCarry(res.next, node.next, carry);
        }
        int sum = node.val + carry;
        res.next.val = sum % 10;
        return sum / 10;
    }
}
