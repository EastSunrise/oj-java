package wsg.oj.java.datastructure;

import java.util.Objects;

/**
 * An implementation of binary search trees.
 *
 * @author Kingen
 * @since 2021/7/11
 */
public class BinarySearchTreeImpl<T extends Comparable<T>>
    extends BinaryTreeImpl<T> implements BinarySearchTree<T> {

    public BinarySearchTreeImpl(T value) {
        super(value);
    }

    public BinarySearchTreeImpl(T value, BinarySearchTree<T> left, BinarySearchTree<T> right) {
        super(value);
        if (left != null && value.compareTo(left.getMax()) <= 0) {
            throw new IllegalArgumentException("Not a valid BST");
        }
        if (right != null && value.compareTo(right.getMin()) >= 0) {
            throw new IllegalArgumentException("Not a valid BST");
        }
    }

    @Override
    public BinarySearchTree<T> getLeft() {
        return (BinarySearchTree<T>) super.getLeft();
    }

    @Override
    public BinarySearchTree<T> getRight() {
        return (BinarySearchTree<T>) super.getRight();
    }

    @Override
    public BinarySearchTree<T> find(T t) {
        Objects.requireNonNull(t);
        int comp = t.compareTo(getValue());
        if (comp == 0) {
            return this;
        }
        if (comp < 0) {
            return !hasLeft() ? null : getLeft().find(t);
        }
        return !hasRight() ? null : getRight().find(t);
    }

    @Override
    public T getMin() {
        BinaryTree<T> current = this;
        while (current.hasLeft()) {
            current = current.getLeft();
        }
        return current.getValue();
    }

    @Override
    public T getMax() {
        BinaryTree<T> current = this;
        while (current.hasRight()) {
            current = current.getRight();
        }
        return current.getValue();
    }

    @Override
    public boolean insert(T t) {
        Objects.requireNonNull(t);
        int comp = t.compareTo(getValue());
        if (comp == 0) {
            return false;
        }
        if (comp < 0) {
            if (!hasLeft()) {
                setLeft(new BinarySearchTreeImpl<>(t));
                return true;
            }
            return getLeft().insert(t);
        }
        if (!hasRight()) {
            setRight(new BinarySearchTreeImpl<>(t));
            return true;
        }
        return getRight().insert(t);
    }

    @Override
    public BinarySearchTree<T> remove(T t) {
        Objects.requireNonNull(t);
        int comp = t.compareTo(getValue());
        if (comp < 0) {
            if (hasLeft()) {
                setLeft(getLeft().remove(t));
            }
            return this;
        }
        if (comp > 0) {
            if (hasRight()) {
                setRight(getRight().remove(t));
            }
            return this;
        }
        if (!hasLeft()) {
            return getRight();
        }
        if (!hasRight()) {
            return getRight();
        }
        BinarySearchTree<T> tmp = this.getRight();
        while (tmp.hasLeft()) {
            tmp = tmp.getLeft();
        }
        setValue(tmp.getValue());
        setRight(getRight().remove(getValue()));
        return this;
    }
}
