package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.datastructure.BinaryTree;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;
import cn.wsg.oj.leetcode.problems.p100.Solution144;
import cn.wsg.oj.leetcode.problems.p100.Solution145;
import cn.wsg.oj.leetcode.problems.p100.Solution173;
import cn.wsg.oj.leetcode.problems.p200.Solution230;
import cn.wsg.oj.leetcode.problems.p700.Solution783;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

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
 */
public class Solution94 implements Solution {

    /**
     * @see BinaryTree#inorderTraversal(Consumer)
     * @see BinaryTree#inorderTraversalIteratively(Consumer)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                res.add(current.val);
                current = current.right;
            }
        }
        return res;
    }
}
