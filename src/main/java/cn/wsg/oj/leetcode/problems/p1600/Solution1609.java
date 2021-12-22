package cn.wsg.oj.leetcode.problems.p1600;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1609. Even Odd Tree (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/even-odd-tree/">Even Odd Tree</a>
 */
public class Solution1609 implements Solution {

    /**
     * @see #LEVEL_ORDER
     */
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean even = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (even) {
                int prev = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.remove();
                    if (node.val % 2 != 1 || node.val <= prev) {
                        return false;
                    }
                    prev = node.val;
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            } else {
                int prev = Integer.MAX_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.remove();
                    if (node.val % 2 != 0 || node.val >= prev) {
                        return false;
                    }
                    prev = node.val;
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            even = !even;
        }
        return true;
    }
}
