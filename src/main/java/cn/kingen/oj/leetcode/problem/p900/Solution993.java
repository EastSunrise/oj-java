package cn.kingen.oj.leetcode.problem.p900;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/cousins-in-binary-tree/">993. Cousins in Binary Tree</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution102
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.BINARY_TREE},
        difficulty = Difficulty.EASY
)
public class Solution993 {

    @Complexity(time = "O(n)", space = "O(n)")
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int px = -1, py = -1; // parent of x and y
            for (int i = queue.size(); i > 0; i--) {
                TreeNode t = queue.remove();
                if (t.left != null) {
                    queue.offer(t.left);
                    if (t.left.val == x) {
                        px = t.val;
                    } else if (t.left.val == y) {
                        py = t.val;
                    }
                }
                if (t.right != null) {
                    queue.offer(t.right);
                    if (t.right.val == x) {
                        px = t.val;
                    } else if (t.right.val == y) {
                        py = t.val;
                    }
                }
            }
            if (px != -1 && py != -1) {
                return px != py;
            } else if (px != -1 || py != -1) {
                return false;
            }
        }
        return false;
    }
}