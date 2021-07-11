package wsg.oj.java.datastructure;

/**
 * Operations for binary search trees.
 *
 * @author Kingen
 * @see <a href="https://eastsunrise.github.io/wiki-kingen/cs/data-structure/binary-search-tree.html">Binary
 * Search Tree</a>
 * @since 2021/7/11
 */
public class BinarySearchTree extends BinaryTree {

    /**
     * Checks whether the given binary tree is a valid BST.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     */
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

}
