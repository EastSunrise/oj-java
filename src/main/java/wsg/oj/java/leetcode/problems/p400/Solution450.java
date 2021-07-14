package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.datastructure.BinarySearchTree;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 450. Delete Node in a BST (Medium)
 *
 * @author Kingen
 * @see Solution776
 * @see <a href="https://leetcode-cn.com/problems/delete-node-in-a-bst/">Delete Node in a BST</a>
 * @since 2021-07-08
 */
class Solution450 extends BinarySearchTree implements Solution {

    /**
     * @see #deleteValue(TreeNode, int)
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        return deleteValue(root, key);
    }
}
