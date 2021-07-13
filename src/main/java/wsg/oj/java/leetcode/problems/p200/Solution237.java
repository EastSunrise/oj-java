package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 237. Delete Node in a Linked List (Easy)
 *
 * @author Kingen
 * @see Solution203
 * @see <a href="https://leetcode-cn.com/problems/delete-node-in-a-linked-list/">Delete Node in a
 * Linked List</a>
 * @since 2021-07-13
 */
class Solution237 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_CONSTANT
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
