package wsg.oj.java.leetcode.problems.p800;

import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 897. Increasing Order Search Tree (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/increasing-order-search-tree/">Increasing Order
 * Search Tree</a>
 * @since 2021-07-27
 */
public class Solution897 implements Solution {

    /**
     * @see #POSTORDER
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public TreeNode increasingBST(TreeNode root) {
        return convert(root)[0];
    }

    /**
     * Converts the bst to increasing bst
     *
     * @return [head node, tail node]
     */
    private TreeNode[] convert(TreeNode node) {
        TreeNode head = node, tail = node;
        if (node.left != null) {
            TreeNode[] left = convert(node.left);
            left[1].right = node;
            node.left = null;
            head = left[0];
        }
        if (node.right != null) {
            TreeNode[] right = convert(node.right);
            node.right = right[0];
            tail = right[1];
        }
        return new TreeNode[]{head, tail};
    }
}
