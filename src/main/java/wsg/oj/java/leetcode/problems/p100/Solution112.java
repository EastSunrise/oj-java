package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 112. Path Sum (Easy)
 *
 * @author Kingen
 * @see Solution113
 * @see Solution124
 * @see Solution129
 * @see Solution437
 * @see Solution666
 * @see <a href="https://leetcode-cn.com/problems/path-sum/">Path Sum</a>
 * @since 2021-07-11
 */
class Solution112 implements Solution {

    /**
     * @see #PREORDER
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            // reach a leaf
            return root.val == targetSum;
        }
        int subSum = targetSum - root.val;
        return hasPathSum(root.left, subSum) || hasPathSum(root.right, subSum);
    }
}
