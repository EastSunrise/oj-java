package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/balanced-binary-tree/">110. Balanced Binary Tree</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution104
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BINARY_TREE},
        difficulty = Difficulty.EASY
)
public class Solution110 {

    @Complexity(time = "O(n)", space = "O(h)", note = "h is the height of the tree")
    public boolean isBalanced(TreeNode root) {
        return dfs(root) >= 0;
    }

    /**
     * @return -1 if the tree is not balanced, otherwise the height of the tree
     */
    private int dfs(TreeNode t) {
        if (t == null) {
            return 0;
        }
        int left = dfs(t.left);
        if (left < 0) { // not balanced subtree
            return -1;
        }
        int right = dfs(t.right);
        if (right < 0) { // not balanced subtree
            return -1;
        }
        if (Math.abs(left - right) > 1) { // not balanced
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}