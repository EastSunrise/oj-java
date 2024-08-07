package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/">104. Maximum Depth of Binary Tree</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution110
 * @see cn.kingen.oj.leetcode.problem.p100.Solution111
 * @see cn.kingen.oj.leetcode.problem.p500.Solution559
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.BINARY_TREE},
        difficulty = Difficulty.EASY
)
public class Solution104 {

    @Complexity(time = "O(n)", space = "O(h)", note = "h is the height of the tree")
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}