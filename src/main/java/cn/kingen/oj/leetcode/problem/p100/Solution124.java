package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-maximum-path-sum/">124. Binary Tree Maximum Path Sum</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution112
 * @see cn.kingen.oj.leetcode.problem.p100.Solution129
 * @see cn.kingen.oj.leetcode.problem.p600.Solution666
 * @see cn.kingen.oj.leetcode.problem.p600.Solution687
 * @see cn.kingen.oj.leetcode.problem.p1300.Solution1376
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2538
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.DYNAMIC_PROGRAMMING, Tag.BINARY_TREE},
        difficulty = Difficulty.HARD
)
public class Solution124 {

    @Complexity(time = "O(n)", space = "O(h)", note = "h is the height of the tree")
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        dfs(root, max);
        return max[0];
    }

    /**
     * @return the max path sum from the node to one of its descendants(including itself)
     */
    private int dfs(TreeNode t, int[] max) {
        if (t == null) {
            return 0;
        }
        int left = Math.max(0, dfs(t.left, max));
        int right = Math.max(0, dfs(t.right, max));
        // the max sum of paths that contain current node
        max[0] = Math.max(max[0], t.val + left + right);
        return t.val + Math.max(left, right);
    }
}