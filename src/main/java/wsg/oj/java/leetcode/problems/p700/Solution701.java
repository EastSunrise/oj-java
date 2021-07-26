package wsg.oj.java.leetcode.problems.p700;

import wsg.oj.java.datastructure.BinarySearchTree;
import wsg.oj.java.datastructure.BinarySearchTreeOpt;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 701. Insert into a Binary Search Tree (MEDIUM)
 *
 * @author Kingen
 * @see Solution700
 * @see <a href="https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/">Insert into a
 * Binary Search Tree</a>
 * @since 2021-07-26
 */
public class Solution701 extends BinarySearchTree implements Solution {

    /**
     * @see BinarySearchTreeOpt#insertValue(TreeNode, int)
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insertValue(root, val);
    }
}
