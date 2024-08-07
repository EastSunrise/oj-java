package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/">235. Lowest Common Ancestor of a Binary Search Tree</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution236
 * @see cn.kingen.oj.leetcode.problem.p1200.Solution1257
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1644
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1650
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1676
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BINARY_SEARCH_TREE, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution235 {

    @Complexity(time = "O(n*log{n})", space = "O(1)")
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        TreeNode t = root;
        while (t != null) {
            if (t.val < min) {
                t = t.right;
            } else if (t.val > max) {
                t = t.left;
            } else {
                return t;
            }
        }
        return null;
    }
}