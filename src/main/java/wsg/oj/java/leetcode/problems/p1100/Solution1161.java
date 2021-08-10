package wsg.oj.java.leetcode.problems.p1100;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 1161. Maximum Level Sum of a Binary Tree (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/maximum-level-sum-of-a-binary-tree/">Maximum Level
 * Sum of a Binary Tree</a>
 * @since 2021-07-27
 */
public class Solution1161 implements Solution {

    /**
     * @see wsg.oj.java.datastructure.BinaryTree#traverseLevels(Function, BiConsumer)
     */
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int min = Integer.MIN_VALUE, idx = 1, res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(), sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (sum > min) {
                res = idx;
                min = sum;
            }
            idx++;
        }
        return res;
    }
}
