package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;

/**
 * 543. Diameter of Binary Tree (EASY)
 *
 * @author Kingen
 * @see Solution1522
 * @see <a href="https://leetcode-cn.com/problems/diameter-of-binary-tree/">Diameter of Binary
 * Tree</a>
 */
class Solution543 implements Solution {

    /**
     * @see #POSTORDER
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
     */
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[]{Integer.MIN_VALUE};
        maxDepth(root, diameter);
        return diameter[0];
    }

    /**
     * @return max depth of the tree
     */
    private int maxDepth(TreeNode node, int[] diameter) {
        int left = node.left == null ? 0 : maxDepth(node.left, diameter);
        int right = node.right == null ? 0 : maxDepth(node.right, diameter);
        // the diameter that passes through this node
        diameter[0] = Math.max(diameter[0], left + right);
        return Math.max(left, right) + 1;
    }
}
