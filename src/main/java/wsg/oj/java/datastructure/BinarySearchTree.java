package wsg.oj.java.datastructure;

/**
 * An implementation of binary search trees.
 *
 * @author Kingen
 * @since 2021/7/11
 */
public class BinarySearchTree extends BinaryTree implements BinarySearchTreeOpt {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     */
    @Override
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * All values of the tree should be in the range (min, max), both exclusive.
     */
    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        int val = node.val;
        if (min != null && val <= min) {
            return false;
        }
        if (max != null && val >= max) {
            return false;
        }
        return (node.left == null || isValidBST(node.left, min, val))
            && (node.right == null || isValidBST(node.right, val, max));
    }

    /**
     * @see wsg.oj.java.Complexity#TIME_H
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    @Override
    public TreeNode deleteValue(TreeNode root, int target) {
        TreeNode rootParent = new TreeNode(-1, root, null);
        TreeNode node = root, parent = rootParent;
        boolean isLeft = true;
        while (node != null) {
            if (node.val < target) {
                parent = node;
                node = node.right;
                isLeft = false;
            } else if (node.val > target) {
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

        // delete the node
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
