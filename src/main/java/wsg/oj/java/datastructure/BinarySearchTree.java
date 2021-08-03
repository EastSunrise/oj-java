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

    @Override
    BinarySearchTree<T> getLeft();

    @Override
    BinarySearchTree<T> getRight();

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
