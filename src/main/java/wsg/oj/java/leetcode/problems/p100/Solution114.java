package wsg.oj.java.leetcode.problems.p100;

import java.util.Stack;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p400.Solution430;

/**
 * 114. Flatten Binary Tree to Linked List (Medium)
 *
 * @author Kingen
 * @see Solution430
 * @see Solution1660
 * @see <a href="https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/">Flatten
 * Binary Tree to Linked List</a>
 * @since 2021-07-11
 */
public class Solution114 implements Solution {

    /**
     * Traverses the tree in RVL order.
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // store the right nodes
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                if (node.right == null) {
                    if (stack.isEmpty()) {
                        // reach the end
                        break;
                    }
                    // switch the branch
                    node.right = stack.pop();
                }
            } else {
                if (node.right != null) {
                    // cache the right node
                    stack.push(node.right);
                }
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }

    /**
     * Appends the right subtree after the rightmost node of the left subtree.
     */
    public void flatten2(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                if (node.right != null) {
                    // append the right subtree after the rightmost of the left subtree
                    TreeNode cursor = node.left;
                    while (cursor.right != null) {
                        cursor = cursor.right;
                    }
                    cursor.right = node.right;
                }
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }
}
