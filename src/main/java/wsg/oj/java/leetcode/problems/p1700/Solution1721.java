package wsg.oj.java.leetcode.problems.p1700;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution19;
import wsg.oj.java.leetcode.problems.p0.Solution24;
import wsg.oj.java.leetcode.problems.p0.Solution25;

/**
 * 1721. Swapping Nodes in a Linked List (MEDIUM)
 *
 * @author Kingen
 * @see Solution19
 * @see Solution24
 * @see Solution25
 * @see <a href="https://leetcode-cn.com/problems/swapping-nodes-in-a-linked-list/">Swapping Nodes
 * in a Linked List</a>
 * @since 2021-07-27
 */
public class Solution1721 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public ListNode swapNodes(ListNode head, int k) {
        ListNode p = head;
        for (int i = 1; i < k; i++) {
            p = p.next;
        }
        ListNode front = p.next, behind = head;
        while (front != null) {
            front = front.next;
            behind = behind.next;
        }
        int tmp = p.val;
        p.val = behind.val;
        behind.val = tmp;
        return head;
    }
}
