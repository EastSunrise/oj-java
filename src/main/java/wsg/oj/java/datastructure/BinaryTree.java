package wsg.oj.java.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * Operations for binary trees.
 *
 * @author Kingen
 * @see <a href="https://eastsunrise.github.io/wiki-kingen/cs/data-structure/binary-tree.html">Binary
 * Tree</a>
 * @since 2021/7/11
 */
public class BinaryTree {

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    /**
     * Recursive inorder traversal.
     */
    public void inorderTraversal(TreeNode node, Consumer<Integer> action) {
        if (node != null) {
            inorderTraversal(node.left, action);
            action.accept(node.val);
            inorderTraversal(node.right, action);
        }
    }

    /**
     * Iterative inorder traversal.
     */
    public void inorderTraversalWithStack(TreeNode root, Consumer<Integer> action) {
        Stack<TreeNode> stack = new Stack<>();
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

    /**
     * Traverses levels iteratively.
     */
    public void traverseLevels(TreeNode root, Consumer<List<Integer>> levelAction) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // traverse a level
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            levelAction.accept(level);
        }
    }

    /**
     * Iterative traversal in level order.
     */
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
