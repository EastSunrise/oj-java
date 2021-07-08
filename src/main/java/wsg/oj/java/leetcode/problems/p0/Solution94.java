package wsg.oj.java.leetcode.problems.p0;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;
import wsg.oj.java.leetcode.problems.p100.Solution144;
import wsg.oj.java.leetcode.problems.p100.Solution145;

/**
 * 94. Binary Tree Inorder Traversal (Easy)
 *
 * @author Kingen
 * @see Solution98
 * @see Solution144
 * @see Solution145
 * @see Solution173
 * @see Solution230
 * @see Solution272
 * @see Solution285
 * @see Solution426
 * @see Solution783
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-inorder-traversal/">Binary Tree
 * Inorder Traversal</a>
 * @since 2021-07-08
 */
public class Solution94 extends Solution {

    /**
     * Recursion.
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
     * Stack.
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
