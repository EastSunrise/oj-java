package cn.wsg.oj.leetcode.problems.p1700;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.ListNode;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution19;
import cn.wsg.oj.leetcode.problems.p0.Solution24;
import cn.wsg.oj.leetcode.problems.p0.Solution25;

/**
 * 1721. Swapping Nodes in a Linked List (MEDIUM)
 *
 * @author Kingen
 * @see Solution19
 * @see Solution24
 * @see Solution25
 * @see <a href="https://leetcode-cn.com/problems/swapping-nodes-in-a-linked-list/">Swapping Nodes
 * in a Linked List</a>
 */
public class Solution1721 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
