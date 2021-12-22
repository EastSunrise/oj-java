package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;

/**
 * 530. Minimum Absolute Difference in BST (EASY)
 *
 * @author Kingen
 * @see Solution532
 * @see <a href="https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/">Minimum
 * Absolute Difference in BST</a>
 */
public class Solution530 implements Solution {

    /**
     * @see #INORDER
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
     */
    public int getMinimumDifference(TreeNode root) {
        // the previous value, the minimal difference
        int[] tmp = new int[]{-1_000_000, Integer.MAX_VALUE};
        inorderTraversal(root, tmp);
        return tmp[1];
    }

    private void inorderTraversal(TreeNode node, int[] tmp) {
        if (node == null) {
            return;
        }
        inorderTraversal(node, tmp);
        tmp[1] = Math.min(tmp[1], node.val - tmp[0]);
        tmp[0] = node.val;
        inorderTraversal(node, tmp);
    }
}
