package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/path-sum/">112. Path Sum</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution113
 * @see cn.kingen.oj.leetcode.problem.p100.Solution124
 * @see cn.kingen.oj.leetcode.problem.p100.Solution129
 * @see cn.kingen.oj.leetcode.problem.p400.Solution437
 * @see cn.kingen.oj.leetcode.problem.p600.Solution666
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.BINARY_TREE},
        difficulty = Difficulty.EASY
)
public class Solution112 {

    @Complexity(time = "O(n)", space = "O(h)", note = "h is the height of the tree")
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) { // reach a leaf
            return root.val == targetSum;
        }
        targetSum -= root.val;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}