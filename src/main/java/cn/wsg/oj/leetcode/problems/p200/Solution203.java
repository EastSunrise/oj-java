package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.ListNode;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution27;

/**
 * 203. Remove Linked List Elements (Easy)
 *
 * @author Kingen
 * @see Solution27
 * @see Solution237
 * @see <a href="https://leetcode-cn.com/problems/remove-linked-list-elements/">Remove Linked List
 * Elements</a>
 */
public class Solution203 implements Solution {

    /**
     * Deletes the targets node by node.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode(0, head);
        ListNode cur = res;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return res.next;
    }
}
