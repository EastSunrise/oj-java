package cn.wsg.oj.leetcode.problems.interview.ch2;

import cn.wsg.oj.leetcode.problems.base.ListNode;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 面试题 2.3. Delete Middle Node LCCI (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/delete-middle-node-lcci/">Delete Middle Node
 * LCCI</a>
 */
public class Interview3 implements Solution {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
