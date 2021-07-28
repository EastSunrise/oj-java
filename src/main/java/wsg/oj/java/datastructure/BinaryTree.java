package wsg.oj.java.datastructure;

import java.util.Deque;
import java.util.LinkedList;
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
public class BinaryTree implements BinaryTreeOpt {

    @Override
    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    @Override
    public boolean equals(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }
        return q != null && p.val == q.val
            && equals(p.left, q.left) && equals(p.right, q.right);
    }

    @Override
    public void preorderTraversal(TreeNode node, Consumer<Integer> action) {
        if (node != null) {
            action.accept(node.val);
            preorderTraversal(node.left, action);
            preorderTraversal(node.right, action);
        }
    }

    @Override
    public void preorderTraversalWithStack(TreeNode root, Consumer<Integer> action) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            action.accept(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    @Override
    public void inorderTraversal(TreeNode node, Consumer<Integer> action) {
        if (node != null) {
            inorderTraversal(node.left, action);
            action.accept(node.val);
            inorderTraversal(node.right, action);
        }
    }

    @Override
    public void inorderTraversalWithStack(TreeNode root, Consumer<Integer> action) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        do {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                action.accept(current.val);
                current = current.right;
            }
        } while (current != null || !stack.isEmpty());
    }

    @Override
    public void postorderTraversal(TreeNode node, Consumer<Integer> action) {
        if (node != null) {
            inorderTraversal(node.left, action);
            inorderTraversal(node.right, action);
            action.accept(node.val);
        }
    }

    @Override
    public void postorderTraversalWithStack(TreeNode root, Consumer<Integer> action) {
        TreeNode current = root;
        TreeNode last = null;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.element();
            if (current.right == null || current.right == last) {
                action.accept(current.val);
                stack.pop();
                last = current;
                current = null;
            } else {
                current = current.right;
            }
        }
    }

    @Override
    public <T> void traverseLevels(TreeNode root, Function<Integer, T> constructor,
        BiConsumer<T, Integer> action) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // traverse a level
            int size = queue.size();
            T level = constructor.apply(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                action.accept(level, node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    @Override
    public void levelOrderTraversal(TreeNode root, Consumer<Integer> action) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            action.accept(current.val);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}
