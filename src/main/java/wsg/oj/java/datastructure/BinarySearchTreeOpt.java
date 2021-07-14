package wsg.oj.java.datastructure;

/**
 * Operations of binary search trees.
 *
 * @author Kingen
 * @see <a href="https://eastsunrise.github.io/wiki-kingen/cs/data-structure/binary-search-tree.html">Binary
 * Search Tree</a>
 * @since 2021/7/14
 */
public interface BinarySearchTreeOpt extends BinaryTreeOpt {

    /**
     * Checks whether the given binary tree is a valid BST.
     */
    boolean isValidBST(TreeNode root);

    /**
     * Deletes the node of the specified target.
     */
    TreeNode deleteValue(TreeNode root, int target);
}
