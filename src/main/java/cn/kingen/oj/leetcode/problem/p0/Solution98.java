package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/validate-binary-search-tree/">98. Validate Binary Search Tree</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution94
 * @see cn.kingen.oj.leetcode.problem.p500.Solution501
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BINARY_SEARCH_TREE, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution98 {

    @Complexity(time = "O(n)", space = "O(h)", note = "h is the height of the tree")
    public boolean isValidBST(TreeNode root) {
        return isBetween(root, null, null);
    }

    /**
     * Whether all the nodes in the subtree of {@code t} are between {@code min} and {@code max}.
     */
    private boolean isBetween(TreeNode t, Integer min, Integer max) {
        if (min != null && t.val <= min) {
            return false;
        }
        if (max != null && t.val >= max) {
            return false;
        }
        return (t.left == null || isBetween(t.left, min, t.val))
                && (t.right == null || isBetween(t.right, t.val, max));
    }
}