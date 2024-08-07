package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/minimum-absolute-difference-in-bst/">530. Minimum Absolute Difference in BST</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p500.Solution532
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.BINARY_SEARCH_TREE, Tag.BINARY_TREE},
        difficulty = Difficulty.EASY
)
public class Solution530 {

    @Complexity(time = "O(n)", space = "O(h)", note = "h is the height of the tree")
    public int getMinimumDifference(TreeNode root) {
        return dfs(root, new int[]{-1_000_000});
    }

    private int dfs(TreeNode t, int[] prev) {
        if (t == null) {
            return Integer.MAX_VALUE;
        }
        int min = Math.min(dfs(t.left, prev), t.val - prev[0]);
        prev[0] = t.val;
        return Math.min(min, dfs(t.right, prev));
    }
}