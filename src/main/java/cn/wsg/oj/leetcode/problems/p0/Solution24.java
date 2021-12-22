package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.ListNode;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p1700.Solution1721;

/**
 * 24. Swap Nodes in Pairs (Medium)
 *
 * @author Kingen
 * @see Solution25
 * @see Solution1721
 * @see <a href="https://leetcode-cn.com/problems/swap-nodes-in-pairs/">Swap Nodes in Pairs</a>
 */
public class Solution24 implements Solution {

    /**
     * Traverses the list and swaps pairs.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
