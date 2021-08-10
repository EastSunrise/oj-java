package wsg.oj.java.datastructure;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Operations of a binary tree.
 *
 * @author Kingen
 * @see <a href="https://eastsunrise.github.io/wiki-kingen/cs/data-structure/binary-tree.html">Binary
 * Tree</a>
 * @since 2021/7/12
 */
public interface BinaryTree<T> {

    /**
     * Returns the value of the root node of this tree.
     */
    T getValue();

    /**
     * Sets the value of the root node of this tree.
     *
     * @throws NullPointerException if the specified value is null
     */
    void setValue(T value);

    /**
     * Returns {@code true} if this tree has the left subtree.
     */
    boolean hasLeft();

    /**
     * Returns the left subtree of this tree.
     */
    BinaryTree<T> getLeft();

    /**
     * Sets the left subtree of this tree.
     *
     * @param left may be null
     */
    void setLeft(BinaryTree<T> left);

    /**
     * Returns {@code true} if this tree has the right subtree.
     */
    boolean hasRight();

    /**
     * Returns the right subtree of this tree.
     */
    BinaryTree<T> getRight();

    /**
     * Sets the right subtree of this tree.
     *
     * @param right may be null
     */
    void setRight(BinaryTree<T> right);

    /**
     * Returns the height of this tree.
     */
    int getHeight();

    /**
     * Returns {@code true} if this tree contains the specified value.
     *
     * @throws NullPointerException if the specified value is null
     */
    boolean contains(T t);

    /**
     * Finds the node with the specified value from this tree.
     *
     * @return the first node with the specified value, or {@literal null} if not found
     * @throws NullPointerException if the specified value is null
     */
    BinaryTree<T> find(T t);

    /**
     * Checks whether this tree is a valid BST.
     */
    boolean isBST(Comparator<T> comp);

    /**
     * Recursive preorder traversal.
     */
    void preorderTraversal(Consumer<T> action);

    /**
     * Iterative preorder traversal.
     */
    void preorderTraversalIteratively(Consumer<T> action);

    /**
     * Recursive inorder traversal.
     */
    void inorderTraversal(Consumer<T> action);

    /**
     * Iterative inorder traversal.
     */
    void inorderTraversalIteratively(Consumer<T> action);

    /**
     * Recursive postorder traversal.
     */
    void postorderTraversal(Consumer<T> action);

    /**
     * Iterative postorder traversal.
     */
    void postorderTraversalIteratively(Consumer<T> action);

    /**
     * Iterative level-order traversal.
     */
    void levelOrderTraversal(Consumer<T> action);

    /**
     * Traverses levels iteratively.
     *
     * @param constructor initialize the level, accepting the size of the level
     * @param action      consume each value in the level
     */
    <L> void traverseLevels(Function<Integer, L> constructor, BiConsumer<L, T> action);
}
