package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 513. Find Bottom Left Tree Value (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/find-bottom-left-tree-value/">Find Bottom Left
 * Tree Value</a>
 * @since 2021-07-20
 */
public class Solution513 implements Solution {

    /**
     * @see #POSTORDER
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public int findBottomLeftValue(TreeNode root) {
        int[] leftmost = new int[2];
        traverse(root, 1, leftmost);
        return leftmost[1];
    }

    private void traverse(TreeNode node, int depth, int[] leftmost) {
        if (node.left != null) {
            traverse(node.left, depth + 1, leftmost);
        }
        if (node.right != null) {
            traverse(node.right, depth + 1, leftmost);
        }
        if (depth > leftmost[0]) {
            leftmost[0] = depth;
            leftmost[1] = node.val;
        }
    }
}
