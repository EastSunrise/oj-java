package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.datastructure.BinaryTree;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;
import cn.wsg.oj.leetcode.problems.p100.Solution102;
import cn.wsg.oj.leetcode.problems.p100.Solution107;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * 637. Average of Levels in Binary Tree (EASY)
 *
 * @author Kingen
 * @see Solution102
 * @see Solution107
 * @see <a href="https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/">Average of
 * Levels in Binary Tree</a>
 */
public class Solution637 implements Solution {

    /**
     * @see BinaryTree#traverseLevels(Function, BiConsumer)
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        double sum = 0;
        int count = 0;
        do {
            TreeNode node = queue.remove();
            if (node != null) {
                sum += node.val;
                count++;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                // finish a level
                res.add(sum / count);
                sum = 0;
                count = 0;
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
            }
        } while (!queue.isEmpty());
        return res;
    }
}
