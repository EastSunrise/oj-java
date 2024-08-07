package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.*;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/convert-bst-to-greater-tree/">538. Convert BST to Greater Tree</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BINARY_SEARCH_TREE, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution538 {

    /**
     * Traverses in RVL order with stack.
     */
    @Complexity(time = "O(n)", space = "O(log{n})")
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = root;
        while (!stack.isEmpty() || t != null) {
            while (t != null) {
                stack.push(t);
                t = t.right;
            }
            t = stack.pop();
            sum += t.val;
            t.val = sum;
            t = t.left;
        }
        return root;
    }
}