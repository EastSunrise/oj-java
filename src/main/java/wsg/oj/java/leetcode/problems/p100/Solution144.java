package wsg.oj.java.leetcode.problems.p100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;
import wsg.oj.java.leetcode.problems.p0.Solution94;

/**
 * 144. Binary Tree Preorder Traversal (Easy)
 *
 * @author Kingen
 * @see Solution94
 * @see Solution255
 * @see Solution589
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-preorder-traversal/">Binary Tree
 * Preorder Traversal</a>
 * @since 2021-07-08
 */
public class Solution144 implements Solution {

    /**
     * Recursion.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(res, root);
        return res;
    }

    private void preorderTraversal(List<Integer> res, TreeNode node) {
        if (node != null) {
            res.add(node.val);
            preorderTraversal(res, node.left);
            preorderTraversal(res, node.right);
        }
    }

    /**
     * Stack.
     */
    public List<Integer> preorderTraversalWithStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            res.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return res;
    }
}
