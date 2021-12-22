package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;

/**
 * 101. Symmetric Tree (Easy)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/symmetric-tree/">Symmetric Tree</a>
 */
public class Solution101 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
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
