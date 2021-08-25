package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.datastructure.BinarySearchTree;
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
class Solution450 implements Solution {

    /**
     * Deletes the node recursively.
     *
     * @see BinarySearchTree#remove(Comparable)
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        // delete this node
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }

        TreeNode precursor = root.left;
        if (precursor.right == null) {
            precursor.right = root.right;
            return precursor;
        }

        TreeNode parent = root;
        while (precursor.right != null) {
            parent = precursor;
            precursor = precursor.right;
        }
        // replace the node with the precursor
        // and then delete the precursor
        root.val = precursor.val;
        parent.right = precursor.left;
        return root;
    }

    /**
     * Deletes the node iteratively.
     */
    public TreeNode deleteNode2(TreeNode root, int key) {
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
