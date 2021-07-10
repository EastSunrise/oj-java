package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 24. Swap Nodes in Pairs (Medium)
 *
 * @author Kingen
 * @see Solution25
 * @see Solution1721
 * @see <a href="https://leetcode-cn.com/problems/swap-nodes-in-pairs/">Swap Nodes in Pairs</a>
 * @since 2021-07-10
 */
class Solution24 implements Solution {

    /**
     * Traverses the list and swaps pairs.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(0, head);
        ListNode node = res;
        while (node.next != null && node.next.next != null) {
            ListNode next = node.next;
            node.next = next.next;
            node = node.next;
            next.next = node.next;
            node.next = next;
            node = node.next;
        }
        return res.next;
    }
}
