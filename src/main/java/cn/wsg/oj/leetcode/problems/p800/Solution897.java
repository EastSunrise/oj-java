package cn.wsg.oj.leetcode.problems.p800;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;

/**
 * 897. Increasing Order Search Tree (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/increasing-order-search-tree/">Increasing Order
 * Search Tree</a>
 */
public class Solution897 implements Solution {

    /**
     * @see #POSTORDER
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
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
