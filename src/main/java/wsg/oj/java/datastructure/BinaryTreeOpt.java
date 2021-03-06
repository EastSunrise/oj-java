package wsg.oj.java.datastructure;

import java.util.List;
import java.util.function.Consumer;

/**
 * Operations of binary trees.
 *
 * @author Kingen
 * @since 2021/7/12
 */
public interface BinaryTreeOpt {

    /**
     * Returns the height of the tree.
     */
    int getHeight(TreeNode node);

    /**
     * Recursive preorder traversal.
     */
    void preorderTraversal(TreeNode node, Consumer<Integer> action);

    /**
     * Iterative preorder traversal.
     */
    void preorderTraversalWithStack(TreeNode root, Consumer<Integer> action);

    /**
     * Recursive inorder traversal.
     */
    void inorderTraversal(TreeNode node, Consumer<Integer> action);

    /**
     * Iterative inorder traversal.
     */
    void inorderTraversalWithStack(TreeNode root, Consumer<Integer> action);

    /**
     * Recursive postorder traversal.
     */
    void postorderTraversal(TreeNode node, Consumer<Integer> action);

    /**
     * Iterative postorder traversal.
     */
    void postorderTraversalWithStack(TreeNode root, Consumer<Integer> action);

    /**
     * Traverses levels iteratively.
     */
    void traverseLevels(TreeNode root, Consumer<List<Integer>> levelAction);

    /**
     * Iterative level-order traversal.
     */
    void levelOrderTraversal(TreeNode root, Consumer<Integer> action);
}
