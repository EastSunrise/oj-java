package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.datastructure.BinarySearchTree;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;

/**
 * 700. Search in a Binary Search Tree (EASY)
 *
 * @author Kingen
 * @see Solution270
 * @see Solution701
 * @see <a href="https://leetcode-cn.com/problems/search-in-a-binary-search-tree/">Search in a
 * Binary Search Tree</a>
 */
public class Solution700 implements Solution {

    /**
     * @see BinarySearchTree#find(Comparable)
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (val == root.val) {
            return root;
        }
        if (val < root.val) {
            return root.left == null ? null : searchBST(root.left, val);
        }
        return root.right == null ? null : searchBST(root.right, val);
    }
}
