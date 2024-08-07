package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/average-of-levels-in-binary-tree/">637. Average of Levels in Binary Tree</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution102
 * @see cn.kingen.oj.leetcode.problem.p100.Solution107
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.BINARY_TREE},
        difficulty = Difficulty.EASY
)
public class Solution637 {

    @Complexity(time = "O(n)", space = "O(n)")
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            long sum = 0, size = queue.size();
            for (int j = queue.size(); j > 0; j--) {
                TreeNode t = queue.remove();
                sum += t.val;
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
            ans.add(sum * 1.0 / size);
        }
        return ans;
    }
}