package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution27;

/**
 * 203. Remove Linked List Elements (Easy)
 *
 * @author Kingen
 * @see Solution27
 * @see Solution237
 * @see <a href="https://leetcode-cn.com/problems/remove-linked-list-elements/">Remove Linked List
 * Elements</a>
 * @since 2021-07-12
 */
public class Solution203 implements Solution {

    /**
     * Deletes the targets node by node.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode(0, head);
        ListNode cursor = res;
        while (cursor.next != null) {
            if (cursor.next.val == val) {
                cursor.next = cursor.next.next;
            } else {
                cursor = cursor.next;
            }
        }
        return res.next;
    }
}
