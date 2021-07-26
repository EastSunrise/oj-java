package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 109. Convert Sorted List to Binary Search Tree (Medium)
 *
 * @author Kingen
 * @see Solution108
 * @see <a href="https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/">Convert
 * Sorted List to Binary Search Tree</a>
 * @since 2021-07-11
 */
public class Solution109 implements Solution {

    /**
     * @see #PREORDER
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int len = 1;
        ListNode cursor = head.next;
        while (cursor != null) {
            cursor = cursor.next;
            len++;
        }
        TreeNode root = new TreeNode();
        buildTree(root, head, len);
        return root;
    }

    /**
     * @param node the tree to be built
     * @param len  the total numbers of nodes of the tree
     * @return remaining list nodes
     */
    private ListNode buildTree(TreeNode node, ListNode remaining, int len) {
        int mid = len >>> 1;
        if (mid > 0) {
            // there is left subtree
            node.left = new TreeNode();
            remaining = buildTree(node.left, remaining, mid);
        }
        node.val = remaining.val;
        remaining = remaining.next;
        int rightLen = len - mid - 1;
        if (rightLen > 0) {
            // there is right subtree
            node.right = new TreeNode();
            remaining = buildTree(node.right, remaining, rightLen);
        }
        return remaining;
    }
}
