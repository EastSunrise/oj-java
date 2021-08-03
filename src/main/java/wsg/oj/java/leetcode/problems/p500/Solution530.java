package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 530. Minimum Absolute Difference in BST (EASY)
 *
 * @author Kingen
 * @see Solution532
 * @see <a href="https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/">Minimum
 * Absolute Difference in BST</a>
 * @since 2021-07-20
 */
public class Solution530 implements Solution {

    /**
     * @see #INORDER
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
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
