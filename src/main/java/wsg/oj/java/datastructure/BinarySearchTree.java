package wsg.oj.java.datastructure;

/**
 * Operations of a binary search tree.
 *
 * @author Kingen
 * @see <a href="https://eastsunrise.github.io/wiki-kingen/cs/data-structure/binary-search-tree.html">Binary
 * Search Tree</a>
 * @since 2021/7/14
 */
public interface BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    /**
     * Sets the value of the root node of this tree.
     *
     * @throws IllegalArgumentException if the tree turns invalid BST after setting the value
     * @throws NullPointerException     if the specified value is null
     */
    @Override
    void setValue(T value);

    @Override
    BinarySearchTree<T> getLeft();

    /**
     * Sets the left subtree of this tree.
     *
     * @param left may be null
     * @throws ClassCastException       if the specified left subtree is not a BST
     * @throws IllegalArgumentException if the tree turns invalid BST after setting the left
     *                                  subtree.
     */
    @Override
    void setLeft(BinaryTree<T> left);

    @Override
    BinarySearchTree<T> getRight();

    /**
     * Sets the right subtree of this tree.
     *
     * @param right may be null
     * @throws ClassCastException       if the specified right subtree is not a BST
     * @throws IllegalArgumentException if the tree turns invalid BST after setting the right
     *                                  subtree.
     */
    @Override
    void setRight(BinaryTree<T> right);

    /**
     * Returns the minimal value within this tree.
     */
    T getMin();

    /**
     * Returns the maximal value within this tree.
     */
    T getMax();

    /**
     * Finds the node with the specified value from this tree.
     *
     * @return the node with the specified value, or {@literal null} if not found
     * @throws NullPointerException if the specified value is null
     */
    @Override
    BinarySearchTree<T> find(T t);

    /**
     * Inserts the specified value into this tree if it is not already present.
     *
     * @return {@code true} if this tree did not already contain the specified value
     * @throws NullPointerException if the specified value is null
     */
    boolean insert(T t);

    /**
     * Removes the specified value from this tree if it is present.
     *
     * @return the left tree after removing the specified value
     * @throws NullPointerException if the specified element is null
     */
    BinarySearchTree<T> remove(T t);
}
