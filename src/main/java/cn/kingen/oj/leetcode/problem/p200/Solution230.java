package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/kth-smallest-element-in-a-bst/">230. Kth Smallest Element in a BST</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution94
 * @see cn.kingen.oj.leetcode.problem.p600.Solution671
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BINARY_SEARCH_TREE, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution230 {

    @Complexity(time = "O(h+k)", space = "O(h)", note = "h is the height of the tree")
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>(k);
        TreeNode t = root;
        while (t != null) {
            stack.push(t);
            t = t.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (--k == 0) {
                return node.val;
            }
            t = node.right;
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
        }
        throw new IllegalArgumentException("out of range");
    }
}