package wsg.oj.java.leetcode.problems.p600;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 662. Maximum Width of Binary Tree (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/maximum-width-of-binary-tree/">Maximum Width of
 * Binary Tree</a>
 * @since 2021-07-23
 */
public class Solution662 implements Solution {

    /**
     * @see #PREORDER
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public int widthOfBinaryTree(TreeNode root) {
        List<int[]> levels = new ArrayList<>();
        traverse(levels, root, 0, 0);
        int max = Integer.MIN_VALUE;
        for (int[] level : levels) {
            max = Math.max(max, level[1] - level[0] + 1);
        }
        return max;
    }

    private void traverse(List<int[]> levels, TreeNode node, int depth, int index) {
        if (node == null) {
            return;
        }
        if (depth == levels.size()) {
            // first node of the level
            levels.add(new int[]{index, index});
        } else {
            int[] level = levels.get(depth);
            level[0] = Math.min(level[0], index);
            level[1] = Math.max(level[1], index);
        }
        traverse(levels, node.left, depth + 1, 2 * index + 1);
        traverse(levels, node.right, depth + 1, 2 * index + 2);
    }
}
