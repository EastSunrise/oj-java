package wsg.oj.java.leetcode.problems.p700;

import wsg.oj.java.datastructure.BinarySearchTree;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 701. Insert into a Binary Search Tree (MEDIUM)
 *
 * @author Kingen
 * @see Solution700
 * @see <a href="https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/">Insert into a
 * Binary Search Tree</a>
 * @since 2021-07-26
 */
public class Solution701 implements Solution {

    /**
     * @see BinarySearchTree#insert(Comparable)
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
