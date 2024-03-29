package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;
import cn.wsg.oj.leetcode.problems.p400.Solution437;

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
 */
public class Solution112 implements Solution {

    /**
     * @see #DFS
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
