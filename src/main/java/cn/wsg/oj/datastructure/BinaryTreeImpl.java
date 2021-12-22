package cn.wsg.oj.datastructure;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * An implementation of binary trees.
 *
 * @author Kingen
 */
public class BinaryTreeImpl<T> implements BinaryTree<T> {

    private T value;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTreeImpl(T value) {
        this.value = Objects.requireNonNull(value);
    }

    public BinaryTreeImpl(T value, BinaryTree<T> left, BinaryTree<T> right) {
        this.value = Objects.requireNonNull(value);
        this.left = left;
        this.right = right;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void setValue(T value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean hasLeft() {
        return left != null;
    }

    @Override
    public BinaryTree<T> getLeft() {
        return left;
    }

    @Override
    public void setLeft(BinaryTree<T> left) {
        this.left = left;
    }

    @Override
    public boolean hasRight() {
        return right != null;
    }

    @Override
    public BinaryTree<T> getRight() {
        return right;
    }

    @Override
    public void setRight(BinaryTree<T> right) {
        this.right = right;
    }

    @Override
    public int getHeight() {
        int lh = hasLeft() ? left.getHeight() : 0;
        int rh = hasRight() ? right.getHeight() : 0;
        return Math.max(lh, rh) + 1;
    }

    @Override
    public boolean contains(T t) {
        return find(t) != null;
    }

    @Override
    public BinaryTree<T> find(T t) {
        Objects.requireNonNull(t);
        if (value.equals(t)) {
            return this;
        }
        if (left != null) {
            BinaryTree<T> res = left.find(t);
            if (res != null) {
                return res;
            }
        }
        if (right != null) {
            return right.find(t);
        }
        return null;
    }

    @Override
    public boolean isBST(Comparator<T> comp) {
        return within(comp, this, null, null);
    }

    private boolean within(Comparator<T> comp, BinaryTree<T> tree, T min, T max) {
        if (min != null && comp.compare(tree.getValue(), min) <= 0) {
            return false;
        }
        if (max != null && comp.compare(tree.getValue(), max) >= 0) {
            return false;
        }
        return (!tree.hasLeft() || within(comp, tree.getLeft(), min, value))
            && (!tree.hasRight() || within(comp, tree.getRight(), value, max));
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        BinaryTree<?> that = (BinaryTree<?>) other;
        return Objects.equals(value, that.getValue()) && Objects.equals(left, that.getLeft())
            && Objects.equals(right, that.getRight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, left, right);
    }

    @Override
    public void preorderTraversal(Consumer<T> action) {
        action.accept(value);
        if (left != null) {
            left.preorderTraversal(action);
        }
        if (right != null) {
            right.preorderTraversal(action);
        }
    }

    @Override
    public void preorderTraversalIteratively(Consumer<T> action) {
        Deque<BinaryTree<T>> stack = new LinkedList<>();
        stack.push(this);
        while (!stack.isEmpty()) {
            BinaryTree<T> current = stack.pop();
            action.accept(current.getValue());
            if (current.hasRight()) {
                stack.push(current.getRight());
            }
            if (current.hasLeft()) {
                stack.push(current.getLeft());
            }
        }
    }

    @Override
    public void inorderTraversal(Consumer<T> action) {
        if (left != null) {
            left.inorderTraversal(action);
        }
        action.accept(value);
        if (right != null) {
            right.inorderTraversal(action);
        }
    }

    @Override
    public void inorderTraversalIteratively(Consumer<T> action) {
        Deque<BinaryTree<T>> stack = new LinkedList<>();
        BinaryTree<T> current = this;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                action.accept(value);
                current = current.getRight();
            }
        }
    }

    @Override
    public void postorderTraversal(Consumer<T> action) {
        if (left != null) {
            left.postorderTraversal(action);
        }
        if (right != null) {
            right.postorderTraversal(action);
        }
        action.accept(value);
    }

    @Override
    public void postorderTraversalIteratively(Consumer<T> action) {
        BinaryTree<T> current = this;
        BinaryTree<T> last = null;
        Deque<BinaryTree<T>> stack = new LinkedList<>();
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.element();
            if (!current.hasRight() || current.getRight() == last) {
                action.accept(current.getValue());
                stack.pop();
                last = current;
                current = null;
            } else {
                current = current.getRight();
            }
        }
    }

    @Override
    public void levelOrderTraversal(Consumer<T> action) {
        Queue<BinaryTree<T>> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            BinaryTree<T> current = queue.remove();
            action.accept(current.getValue());
            if (current.hasLeft()) {
                queue.add(current.getLeft());
            }
            if (current.hasRight()) {
                queue.add(current.getRight());
            }
        }
    }

    @Override
    public <L> void traverseLevels(Function<Integer, L> constructor, BiConsumer<L, T> action) {
        Queue<BinaryTree<T>> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            // traverse a level
            int size = queue.size();
            L level = constructor.apply(size);
            for (int i = 0; i < size; i++) {
                BinaryTree<T> node = queue.remove();
                action.accept(level, node.getValue());
                if (node.hasLeft()) {
                    queue.add(node.getLeft());
                }
                if (node.hasRight()) {
                    queue.add(node.getRight());
                }
            }
        }
    }
}
