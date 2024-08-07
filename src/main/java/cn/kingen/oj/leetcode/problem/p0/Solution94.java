package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.*;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/">94. Binary Tree Inorder Traversal</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution98
 * @see cn.kingen.oj.leetcode.problem.p100.Solution144
 * @see cn.kingen.oj.leetcode.problem.p100.Solution145
 * @see cn.kingen.oj.leetcode.problem.p100.BSTIterator
 * @see cn.kingen.oj.leetcode.problem.p200.Solution230
 * @see cn.kingen.oj.leetcode.problem.p200.Solution272
 * @see cn.kingen.oj.leetcode.problem.p200.Solution285
 * @see cn.kingen.oj.leetcode.problem.p400.Solution426
 * @see cn.kingen.oj.leetcode.problem.p700.Solution783
 */
@Question(
        tags = {Tag.STACK, Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BINARY_TREE},
        difficulty = Difficulty.EASY
)
public class Solution94 {

    @Complexity(time = "O(n)", space = "O(h)", note = "h is the height of the tree")
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                ans.add(current.val);
                current = current.right;
            }
        }
        return ans;
    }
}