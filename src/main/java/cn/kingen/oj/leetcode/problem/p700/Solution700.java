package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/search-in-a-binary-search-tree/">700. Search in a Binary Search Tree</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution270
 * @see cn.kingen.oj.leetcode.problem.p700.Solution701
 */
@Question(
        tags = {Tag.TREE, Tag.BINARY_SEARCH_TREE, Tag.BINARY_TREE},
        difficulty = Difficulty.EASY
)
public class Solution700 {

    @Complexity(time = "O(h)", space = "O(1)", note = "h is the height of the tree")
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode t = root;
        while (t != null) {
            if (t.val == val) {
                return t;
            }
            if (t.val > val) {
                t = t.left;
            } else {
                t = t.right;
            }
        }
        return null;
    }
}