package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.ListNode;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 237. Delete Node in a Linked List (Easy)
 *
 * @author Kingen
 * @see Solution203
 * @see <a href="https://leetcode-cn.com/problems/delete-node-in-a-linked-list/">Delete Node in a
 * Linked List</a>
 */
class Solution237 implements Solution {

    /**
     * @see Complexity#TIME_CONSTANT
     * @see Complexity#SPACE_CONSTANT
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
