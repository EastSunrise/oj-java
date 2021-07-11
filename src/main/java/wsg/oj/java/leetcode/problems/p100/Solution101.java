package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 101. Symmetric Tree (Easy)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/symmetric-tree/">Symmetric Tree</a>
 * @since 2021-07-11
 */
class Solution101 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        }
        return right != null && left.val == right.val
            && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
