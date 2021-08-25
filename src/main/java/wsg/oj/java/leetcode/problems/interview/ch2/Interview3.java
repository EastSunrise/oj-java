package wsg.oj.java.leetcode.problems.interview.ch2;

import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 面试题 2.3. Delete Middle Node LCCI (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/delete-middle-node-lcci/">Delete Middle Node
 * LCCI</a>
 * @since 2021-07-28
 */
public class Interview3 implements Solution {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
