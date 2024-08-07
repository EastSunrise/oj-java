package cn.kingen.oj.leetcode.problem.p900;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/range-sum-of-bst/">938. Range Sum of BST</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BINARY_SEARCH_TREE, Tag.BINARY_TREE},
        difficulty = Difficulty.EASY
)
public class Solution938 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}