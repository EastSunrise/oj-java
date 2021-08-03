package wsg.oj.java.datastructure;

import java.util.Objects;

/**
 * An implementation of binary search trees.
 *
 * @author Kingen
 * @since 2021/7/11
 */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> implements
    BinarySearchTreeOpt<T> {

    public BinarySearchTree(T value) {
        super(value);
    }

    public BinarySearchTree(T value, BinarySearchTree<T> left, BinarySearchTree<T> right) {
        super(value);
        if (left != null && value.compareTo(left.getMax()) <= 0) {
            throw new IllegalArgumentException("Not a valid BST");
        }
        if (right != null && value.compareTo(right.getMin()) >= 0) {
            throw new IllegalArgumentException("Not a valid BST");
        }
    }

    @Override
    public BinarySearchTree<T> find(T t) {
        Objects.requireNonNull(t);
        int comp = t.compareTo(value);
        if (comp == 0) {
            return this;
        }
        if (comp < 0) {
            return left == null ? null : (BinarySearchTree<T>) left.find(t);
        }
        return right == null ? null : (BinarySearchTree<T>) right.find(t);
    }

    @Override
    public T getMin() {
        BinaryTree<T> current = this;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    @Override
    public T getMax() {
        BinaryTree<T> current = this;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }

    @Override
    public boolean insert(T t) {
        Objects.requireNonNull(t);
        int comp = t.compareTo(value);
        if (comp == 0) {
            return false;
        }
        if (comp < 0) {
            if (left == null) {
                left = new BinarySearchTree<>(t);
                return true;
            }
            return ((BinarySearchTree<T>) left).insert(t);
        }
        if (right == null) {
            right = new BinarySearchTree<>(t);
            return true;
        }
        return ((BinarySearchTree<T>) right).insert(t);
    }

    @Override
    public BinarySearchTree<T> remove(T t) {
        Objects.requireNonNull(t);
        int comp = t.compareTo(value);
        if (comp < 0) {
            if (left != null) {
                left = ((BinarySearchTree<T>) left).remove(t);
            }
            return this;
        }
        if (comp > 0) {
            if (right != null) {
                right = ((BinarySearchTree<T>) right).remove(t);
            }
            return this;
        }
        if (left == null) {
            return (BinarySearchTree<T>) right;
        }
        if (right == null) {
            return (BinarySearchTree<T>) left;
        }
        BinarySearchTree<T> tmp = (BinarySearchTree<T>) this.right;
        while (tmp.left != null) {
            tmp = (BinarySearchTree<T>) tmp.left;
        }
        this.value = tmp.value;
        right = ((BinarySearchTree<T>) right).remove(value);
        return this;
    }
}
