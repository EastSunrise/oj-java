package wsg.oj.java.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Operations for binary trees.
 *
 * @author Kingen
 * @see <a href="https://eastsunrise.github.io/wiki-kingen/cs/data-structure/binary-tree.html">Binary
 * Tree</a>
 * @since 2021/7/11
 */
public class BinaryTree {

    /**
     * Inorder traversal with recursion.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode node, List<Integer> result) {
        if (node != null) {
            inorderTraversal(node.left, result);
            result.add(node.val);
            inorderTraversal(node.right, result);
        }
    }

    /**
     * Inorder traversal with a stack.
     */
    public List<Integer> inorderTraversalWithStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        do {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                res.add(current.val);
                current = current.right;
            }
        } while (current != null || !stack.isEmpty());
        return res;
    }
}
