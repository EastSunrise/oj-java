package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree/">111. Minimum Depth of Binary Tree</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution102
 * @see cn.kingen.oj.leetcode.problem.p100.Solution104
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.BINARY_TREE},
        difficulty = Difficulty.EASY
)
public class Solution111 {

    /**
     * Depth-first search.
     */
    @Complexity(time = "O(n)", space = "O(h)", note = "h is the height of the tree")
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    /**
     * Traverse the tree in level order.
     */
    @Complexity(time = "O(n)", space = "O(n)")
    public int minDepth_2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            for (int i = 0, size = queue.size(); i < size; i++) {
                TreeNode t = queue.remove();
                if (t.left == null && t.right == null) {
                    return depth;
                }
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
        }
        return depth;
    }
}