package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/insert-into-a-binary-search-tree/">701. Insert into a Binary Search Tree</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p700.Solution700
 */
@Question(
        tags = {Tag.TREE, Tag.BINARY_SEARCH_TREE, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution701 {

    @Complexity(time = "O(h)", space = "O(1)", note = "h is the height of the tree")
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode p = null, t = root;
        while (t != null) {
            if (t.val == val) {
                return root;
            }
            p = t;
            if (val < t.val) {
                t = t.left;
            } else {
                t = t.right;
            }
        }
        if (val < p.val) {
            p.left = new TreeNode(val);
        } else {
            p.right = new TreeNode(val);
        }
        return root;
    }
}