package cn.kingen.oj.leetcode.problem.p1300;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/linked-list-in-binary-tree/">1367. Linked List in Binary Tree</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.LINKED_LIST, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution1367 {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return startWith(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean startWith(TreeNode t, ListNode head) {
        if (head == null) {
            return true;
        }
        if (t == null) {
            return false;
        }
        return head.val == t.val && (startWith(t.left, head.next) || startWith(t.right, head.next));
    }
}