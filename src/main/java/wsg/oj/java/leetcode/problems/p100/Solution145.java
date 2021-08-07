package wsg.oj.java.leetcode.problems.p100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import wsg.oj.java.datastructure.BinaryTree;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;
import wsg.oj.java.leetcode.problems.p0.Solution94;
import wsg.oj.java.leetcode.problems.p500.Solution590;

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
     * @see BinaryTree#postorderTraversal(Consumer)
     * @see BinaryTree#postorderTraversalIteratively(Consumer)
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode current = root, prev = null;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.element();
            if (current.right == null || current.right == prev) {
                res.add(current.val);
                prev = stack.pop();
                current = null;
            } else {
                current = current.right;
            }
        }
        return res;
    }
}
