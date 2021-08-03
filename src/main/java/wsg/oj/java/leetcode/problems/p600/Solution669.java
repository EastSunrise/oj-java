package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 669. Trim a Binary Search Tree (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/trim-a-binary-search-tree/">Trim a Binary Search
 * Tree</a>
 * @since 2021-07-23
 */
public class Solution669 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            // trim the left subtree and this node
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            // trim the right subtree and this node
            return trimBST(root.left, low, high);
        }
        // trim the left subtree and the right subtree respectively
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
