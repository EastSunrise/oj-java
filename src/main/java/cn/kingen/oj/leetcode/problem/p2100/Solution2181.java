package cn.kingen.oj.leetcode.problem.p2100;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/merge-nodes-in-between-zeros/">2181. Merge Nodes in Between Zeros</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p800.Solution817
 */
@Question(
        tags = {Tag.LINKED_LIST, Tag.SIMULATION},
        difficulty = Difficulty.MEDIUM
)
public class Solution2181 {

    @Complexity(time = "O(n)", space = "O(1)")
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0), p = dummy;
        int val = 0;
        for (ListNode t = head.next; t != null; t = t.next) {
            if (t.val == 0) {
                p.next = new ListNode(val);
                p = p.next;
                val = 0;
            } else {
                val += t.val;
            }
        }
        return dummy.next;
    }
}