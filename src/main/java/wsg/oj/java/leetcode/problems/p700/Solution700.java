package wsg.oj.java.leetcode.problems.p700;

import wsg.oj.java.datastructure.BinarySearchTree;
import wsg.oj.java.datastructure.BinarySearchTreeOpt;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 700. Search in a Binary Search Tree (EASY)
 *
 * @author Kingen
 * @see Solution270
 * @see Solution701
 * @see <a href="https://leetcode-cn.com/problems/search-in-a-binary-search-tree/">Search in a
 * Binary Search Tree</a>
 * @since 2021-07-23
 */
public class Solution700 extends BinarySearchTree implements Solution {

    /**
     * @see BinarySearchTreeOpt#find(TreeNode, int)
     */
    public TreeNode searchBST(TreeNode root, int val) {
        return find(root, val);
    }
}
