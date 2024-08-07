package cn.kingen.oj.leetcode.problem.p2300;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/amount-of-time-for-binary-tree-to-be-infected/">2385. Amount of Time for Binary Tree to Be Infected</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution104
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1730
 * @see cn.kingen.oj.leetcode.problem.p800.Solution863
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2954
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.HASH_TABLE, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution2385 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int amountOfTime(TreeNode root, int start) {
        int[] ans = new int[1];
        dfs(ans, start, root);
        return ans[0];
    }

    /**
     * @return the count of nodes of path from start to t if this subtree contains start
     * or max depth (represented by non-positive) of this subtree
     */
    private int dfs(int[] ans, int start, TreeNode t) {
        if (t == null) {
            return 0;
        }
        int left = dfs(ans, start, t.left);
        int right = dfs(ans, start, t.right);
        if (t.val == start) {
            ans[0] = Math.max(-left, -right);
            return 1;
        }

        if (left <= 0 && right <= 0) { // not contain start
            return Math.min(left, right) - 1;
        }

        ans[0] = Math.max(ans[0], Math.abs(left) + Math.abs(right));
        return Math.max(left, right) + 1;
    }
}