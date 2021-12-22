package cn.wsg.oj.leetcode.problems.base;

/**
 * Common methods of tree operations.
 *
 * @author Kingen
 */
public interface TreeSolution extends Solution {

    default boolean equals(TreeNode t1, TreeNode t2) {
        if (t1 == t2) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && equals(t1.left, t2.left) && equals(t1.right, t2.right);
    }

    default int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return Math.max(left, right) + 1;
    }
}
