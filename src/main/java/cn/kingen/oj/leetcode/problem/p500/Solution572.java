package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.*;

import static cn.kingen.oj.leetcode.util.TreeUtils.getHeight;
import static cn.kingen.oj.leetcode.util.TreeUtils.isEqual;

/**
 * <a href="https://leetcode.cn/problems/subtree-of-another-tree/">572. Subtree of Another Tree</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution250
 * @see cn.kingen.oj.leetcode.problem.p500.Solution508
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BINARY_TREE, Tag.STRING_MATCHING, Tag.HASH_FUNCTION},
        difficulty = Difficulty.EASY
)
public class Solution572 {

    @Complexity(time = "O(n)", space = "O(h)", note = "h is the height of the tree")
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot, getHeight(subRoot)) == -1;
    }

    /**
     * @return -1 if the subtree is found, otherwise the height of the tree
     */
    private int dfs(TreeNode t, TreeNode subRoot, int height) {
        if (t == null) {
            return 0;
        }
        int left = dfs(t.left, subRoot, height);
        if (left == -1) {
            return left;
        }
        int right = dfs(t.right, subRoot, height);
        if (right == -1) {
            return right;
        }
        int h = Math.max(left, right) + 1;
        if (h == height && isEqual(t, subRoot)) {
            return -1;
        }
        return h;
    }
}