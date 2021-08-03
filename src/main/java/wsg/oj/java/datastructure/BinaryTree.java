package wsg.oj.java.datastructure;

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
 * @since 2021/7/11
 */
public class BinaryTree<T> implements BinaryTreeOpt<T> {

    protected T value;
    protected BinaryTree<T> left;
    protected BinaryTree<T> right;

    public BinaryTree(T value) {
        this.value = Objects.requireNonNull(value);
    }

    public BinaryTree(T value, BinaryTree<T> left, BinaryTree<T> right) {
        this.value = Objects.requireNonNull(value);
        this.left = left;
        this.right = right;
    }

    @Override
    public int getHeight() {
        int lh = left == null ? 0 : left.getHeight();
        int rh = right == null ? 0 : right.getHeight();
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
        return within(comp, null, null);
    }

    private boolean within(Comparator<T> comp, T min, T max) {
        if (min != null && comp.compare(value, min) <= 0) {
            return false;
        }
        if (max != null && comp.compare(value, max) >= 0) {
            return false;
        }
        return (left == null || left.within(comp, min, value))
            && (right == null || right.within(comp, value, max));
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
        return Objects.equals(value, that.value) && Objects.equals(left, that.left)
            && Objects.equals(right, that.right);
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
            action.accept(current.value);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
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
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                action.accept(value);
                current = current.right;
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
                current = current.left;
            }
            current = stack.element();
            if (current.right == null || current.right == last) {
                action.accept(current.value);
                stack.pop();
                last = current;
                current = null;
            } else {
                current = current.right;
            }
        }
    }

    @Override
    public void levelOrderTraversal(Consumer<T> action) {
        Queue<BinaryTree<T>> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            BinaryTree<T> current = queue.remove();
            action.accept(current.value);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
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
                action.accept(level, node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }
}
