package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;
import java.util.Stack;

/**
 * 538. Convert BST to Greater Tree (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/convert-bst-to-greater-tree/">Convert BST to
 * Greater Tree</a>
 */
public class Solution538 implements Solution {

    int sum;

    /**
     * Traverses in RVL order.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
     */
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.right);
        sum += node.val;
        node.val = sum;
        traverse(node.left);
    }

    /**
     * Traverses in RVL order.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
     */
    public TreeNode convertBSTWithStack(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            node = node.left;
        }
        return root;
    }
}
