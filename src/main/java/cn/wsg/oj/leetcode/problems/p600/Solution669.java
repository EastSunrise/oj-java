package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;

/**
 * 669. Trim a Binary Search Tree (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/trim-a-binary-search-tree/">Trim a Binary Search
 * Tree</a>
 */
public class Solution669 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
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
