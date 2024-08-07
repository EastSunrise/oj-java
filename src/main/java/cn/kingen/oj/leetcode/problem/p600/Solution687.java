package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/longest-univalue-path/">687. Longest Univalue Path</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution124
 * @see cn.kingen.oj.leetcode.problem.p200.Solution250
 * @see cn.kingen.oj.leetcode.problem.p400.Solution437
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2246
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution687 {

    @Complexity(time = "O(n)", space = "O(h)", note = "h is the height of the tree")
    public int longestUnivaluePath(TreeNode root) {
        int[] ans = {0};
        if (root != null) {
            dfs(ans, root);
        }
        return ans[0];
    }

    private int dfs(int[] max, TreeNode t) {
        // cross: the longest path crossing this node
        // path: the longest path starting with this node
        int cross = 0, path = 1;
        if (t.left != null) {
            int left = dfs(max, t.left);
            if (t.left.val == t.val) {
                cross += left;
                path = Math.max(path, left + 1);
            }
        }
        if (t.right != null) {
            int right = dfs(max, t.right);
            if (t.right.val == t.val) {
                cross += right;
                path = Math.max(path, right + 1);
            }
        }
        max[0] = Math.max(max[0], cross);
        return path;
    }
}