package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/house-robber-iii/">337. House Robber III</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution198
 * @see cn.kingen.oj.leetcode.problem.p200.Solution213
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.DYNAMIC_PROGRAMMING, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution337 {

    @Complexity(time = "O(n)", space = "O(h)", note = "h is the height of the tree")
    public int rob(TreeNode root) {
        return dfs(root)[1];
    }

    /**
     * @return the max value ignoring the root of the subtree, the max value
     */
    private int[] dfs(TreeNode t) {
        int[] max = new int[2];
        if (t.left != null) {
            int[] left = dfs(t.left);
            max[0] += left[1];
            max[1] += left[0];
        }
        if (t.right != null) {
            int[] right = dfs(t.right);
            max[0] += right[1];
            max[1] += right[0];
        }
        max[1] = Math.max(max[0], t.val + max[1]);
        return max;
    }
}