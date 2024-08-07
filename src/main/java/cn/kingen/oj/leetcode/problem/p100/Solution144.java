package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.*;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/">144. Binary Tree Preorder Traversal</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution94
 * @see cn.kingen.oj.leetcode.problem.p200.Solution255
 * @see cn.kingen.oj.leetcode.problem.p500.Solution589
 */
@Question(
        tags = {Tag.STACK, Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BINARY_TREE},
        difficulty = Difficulty.EASY
)
public class Solution144 {

    @Complexity(time = "O(n)", space = "O(h)", note = "h is the height of the tree")
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            ans.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return ans;
    }
}