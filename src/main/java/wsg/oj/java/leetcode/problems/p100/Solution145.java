package wsg.oj.java.leetcode.problems.p100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution94;

/**
 * 145. Binary Tree Postorder Traversal (Easy)
 *
 * @author Kingen
 * @see Solution94
 * @see Solution590
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-postorder-traversal/">Binary Tree
 * Postorder Traversal</a>
 * @since 2021-07-08
 */
public class Solution145 implements Solution {

    /**
     * Recursion.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(res, root);
        return res;
    }

    private void postorderTraversal(List<Integer> res, TreeNode node) {
        if (node != null) {
            postorderTraversal(res, node.left);
            postorderTraversal(res, node.right);
            res.add(node.val);
        }
    }

    /**
     * Stack.
     */
    public List<Integer> postorderTraversalWithStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode current = root;
        TreeNode last = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.peek();
            if (current.right == null || current.right == last) {
                res.add(current.val);
                stack.pop();
                last = current;
                current = null;
            } else {
                current = current.right;
            }
        }
        return res;
    }
}
