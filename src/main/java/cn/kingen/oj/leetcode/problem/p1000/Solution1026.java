package cn.kingen.oj.leetcode.problem.p1000;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/">1026. Maximum Difference Between Node and Ancestor</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution1026 {

    @Complexity(time = "O(n)", space = "O(log{n})")
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return max - min;
        }
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        return Math.max(dfs(root.left, min, max), dfs(root.right, min, max));
    }
}