package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;
import cn.wsg.oj.leetcode.problems.p600.Solution687;

/**
 * 124. Binary Tree Maximum Path Sum (HARD)
 *
 * @author Kingen
 * @see Solution112
 * @see Solution129
 * @see Solution666
 * @see Solution687
 * @see Solution1376
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/">Binary Tree Maximum
 * Path Sum</a>
 */
public class Solution124 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        maxPathSumFrom(root, max);
        return max[0];
    }

    /**
     * @return the max path sum from the node to one of its descendants(including itself)
     */
    private int maxPathSumFrom(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, maxPathSumFrom(node.left, max));
        int right = Math.max(0, maxPathSumFrom(node.right, max));
        // the max sum of paths that contain current node
        max[0] = Math.max(max[0], node.val + left + right);
        return node.val + Math.max(left, right);
    }
}
