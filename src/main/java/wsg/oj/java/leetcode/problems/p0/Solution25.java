package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 25. Reverse Nodes in k-Group (HARD)
 *
 * @author Kingen
 * @see Solution24
 * @see Solution1721
 * @see <a href="https://leetcode-cn.com/problems/reverse-nodes-in-k-group/">Reverse Nodes in
 * k-Group</a>
 * @since 2021-07-17
 */
public class Solution25 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(-1, head), prev = res, next;
        while (true) {
            next = prev.next;
            for (int i = 0; i < k; i++) {
                if (next == null) {
                    return res.next;
                }
                next = next.next;
            }
            ListNode first = prev.next, current = first;
            for (int i = 0; i < k; i++) {
                ListNode tmp = current.next;
                current.next = next;
                next = current;
                current = tmp;
            }
            prev.next = next;
            prev = first;
        }
    }
}
