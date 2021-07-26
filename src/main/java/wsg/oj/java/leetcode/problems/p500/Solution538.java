package wsg.oj.java.leetcode.problems.p500;

import java.util.Stack;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 538. Convert BST to Greater Tree (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/convert-bst-to-greater-tree/">Convert BST to
 * Greater Tree</a>
 * @since 2021-07-20
 */
public class Solution538 implements Solution {

    /**
     * Traverses in RVL order.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public TreeNode convertBST(TreeNode root) {
        traverse(root, 0);
        return root;
    }

    private int traverse(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        if (node.right != null) {
            sum = traverse(node.right, sum);
        }
        sum += node.val;
        node.val = sum;
        if (node.left != null) {
            sum = traverse(node.left, sum);
        }
        return sum;
    }

    /**
     * Traverses in RVL order.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
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
