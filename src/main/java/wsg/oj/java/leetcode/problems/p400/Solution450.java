package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 450. Delete Node in a BST (Medium)
 *
 * @author Kingen
 * @see Solution776
 * @see <a href="https://leetcode-cn.com/problems/delete-node-in-a-bst/">Delete Node in a BST</a>
 * @since 2021-07-08
 */
class Solution450 extends Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode rootParent = new TreeNode(-1, root, null);
        TreeNode node = root, parent = rootParent;
        boolean isLeft = true;
        while (node != null) {
            if (node.val < key) {
                parent = node;
                node = node.right;
                isLeft = false;
            } else if (node.val > key) {
                parent = node;
                node = node.left;
                isLeft = true;
            } else {
                // find the key
                break;
            }
        }
        if (node == null) {
            // not found
            return root;
        }
        // delete node
        // if without left subtree, replace the node with its right subtree
        if (node.left == null) {
            if (isLeft) {
                parent.left = node.right;
            } else {
                parent.right = node.right;
            }
            return rootParent.left;
        }
        // if without right subtree, replace the node with its left subtree
        if (node.right == null) {
            if (isLeft) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
            return rootParent.left;
        }
        // if with both left and right subtrees
        // replace the target with its precursor
        TreeNode precursor = node.left;
        if (precursor.right == null) {
            node.val = precursor.val;
            node.left = precursor.left;
        } else {
            do {
                parent = precursor;
                precursor = precursor.right;
            } while (precursor.right != null);
            node.val = precursor.val;
            // then delete the precursor
            parent.right = precursor.left;
        }
        return rootParent.left;
    }
}
