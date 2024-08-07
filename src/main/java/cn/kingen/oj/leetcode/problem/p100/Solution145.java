package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.*;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/">145. Binary Tree Postorder Traversal</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution94
 * @see cn.kingen.oj.leetcode.problem.p500.Solution590
 */
@Question(
        tags = {Tag.STACK, Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BINARY_TREE},
        difficulty = Difficulty.EASY
)
public class Solution145 {

    @Complexity(time = "O(n)", space = "O(h)", note = "h is the height of the tree")
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>();
        TreeNode current = root, prev = null;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.element();
            if (current.right == null || current.right == prev) {
                ans.add(current.val);
                prev = stack.pop();
                current = null;
            } else {
                current = current.right;
            }
        }
        return ans;
    }
}