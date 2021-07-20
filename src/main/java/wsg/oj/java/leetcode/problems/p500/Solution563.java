package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 563. Binary Tree Tilt (EASY)
 *
 * @author Kingen
 * @see Solution1469
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-tilt/">Binary Tree Tilt</a>
 * @since 2021-07-20
 */
class Solution563 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public int findTilt(TreeNode root) {
        int[] tilt = new int[1];
        sum(root, tilt);
        return tilt[0];
    }

    /**
     * @return sum of all nodes of the tree
     */
    private int sum(TreeNode node, int[] tilt) {
        if (node == null) {
            return 0;
        }
        int left = sum(node.left, tilt);
        int right = sum(node.right, tilt);
        tilt[0] += Math.abs(left - right);
        return node.val + left + right;
    }
}
