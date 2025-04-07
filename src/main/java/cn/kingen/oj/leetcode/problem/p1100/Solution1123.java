package cn.kingen.oj.leetcode.problem.p1100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import cn.kingen.oj.leetcode.support.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-deepest-leaves/">1123. Lowest Common Ancestor of
 * Deepest Leaves</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1676
 */
@Question(
    tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.HASH_TABLE, Tag.BINARY_TREE},
    difficulty = Difficulty.MEDIUM,
    date = "2025-04-04"
)
public class Solution1123 {

    @Complexity(time = "O(n)", space = "O(n)")
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        TreeNode[] ans = new TreeNode[1];
        int[] maxDepth = new int[1];
        dfs(ans, maxDepth, root, 0);
        return ans[0];
    }

    private int dfs(TreeNode[] ans, int[] maxDepth, TreeNode node, int depth) {
        if (node == null) {
            maxDepth[0] = Math.max(maxDepth[0], depth);
            return depth;
        }
        int leftDepth = dfs(ans, maxDepth, node.left, depth + 1);
        int rightDepth = dfs(ans, maxDepth, node.right, depth + 1);
        if (leftDepth == maxDepth[0] && rightDepth == maxDepth[0]) {
            ans[0] = node;
        }
        return Math.max(leftDepth, rightDepth);
    }
}