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
import wsg.oj.java.leetcode.problems.p500.Solution589;

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
     * @see BinaryTree#preorderTraversal(Consumer)
     * @see BinaryTree#preorderTraversalIteratively(Consumer)
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
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
