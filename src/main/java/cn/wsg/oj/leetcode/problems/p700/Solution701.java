package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.datastructure.BinarySearchTree;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;

/**
 * 701. Insert into a Binary Search Tree (MEDIUM)
 *
 * @author Kingen
 * @see Solution700
 * @see <a href="https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/">Insert into a
 * Binary Search Tree</a>
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
