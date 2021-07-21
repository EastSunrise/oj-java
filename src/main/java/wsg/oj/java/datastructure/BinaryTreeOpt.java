package wsg.oj.java.datastructure;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Operations of binary trees.
 *
 * @author Kingen
 * @see <a href="https://eastsunrise.github.io/wiki-kingen/cs/data-structure/binary-tree.html">Binary
 * Tree</a>
 * @since 2021/7/12
 */
public interface BinaryTreeOpt {

    /**
     * Returns the height of the tree.
     */
    int getHeight(TreeNode node);

    /**
     * Checks whether the two trees have the same structure and node values.
     */
    boolean equals(TreeNode p, TreeNode q);

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
     *
     * @param constructor initialize the level, accepting the size of the level
     * @param action      consume each value in the level
     */
    <T> void traverseLevels(TreeNode root, Function<Integer, T> constructor,
        BiConsumer<T, Integer> action);

    /**
     * Iterative level-order traversal.
     */
    void levelOrderTraversal(TreeNode root, Consumer<Integer> action);
}
