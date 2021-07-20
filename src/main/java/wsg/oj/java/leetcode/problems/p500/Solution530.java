package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.datastructure.BinaryTree;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 530. Minimum Absolute Difference in BST (EASY)
 *
 * @author Kingen
 * @see Solution532
 * @see <a href="https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/">Minimum
 * Absolute Difference in BST</a>
 * @since 2021-07-20
 */
class Solution530 extends BinaryTree implements Solution {

    /**
     * @see #INORDER
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public int getMinimumDifference(TreeNode root) {
        // the previous value, the minimal difference
        int[] tmp = new int[]{-1_000_000, Integer.MAX_VALUE};
        inorderTraversal(root, val -> {
            tmp[1] = Math.min(tmp[1], val - tmp[0]);
            tmp[0] = val;
        });
        return tmp[1];
    }
}
