package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/second-minimum-node-in-a-binary-tree/">671. Second Minimum Node In a Binary Tree</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution230
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BINARY_TREE},
        difficulty = Difficulty.EASY
)
public class Solution671 {

    @Complexity(time = "O(n)", space = "O(h)", note = "n is the height of tree")
    public int findSecondMinimumValue(TreeNode root) {
        int min = root.val;
        if (root.left != null) {
            int left = root.left.val, right = root.right.val;
            if (left == min) {
                left = findSecondMinimumValue(root.left);
            }
            if (right == min) {
                right = findSecondMinimumValue(root.right);
            }
            if (left == -1) {
                return right;
            }
            if (right == -1) {
                return left;
            }
            return Math.min(left, right);
        }
        return -1;
    }
}