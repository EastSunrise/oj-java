package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;
import cn.wsg.oj.leetcode.problems.p100.Solution198;
import cn.wsg.oj.leetcode.problems.p200.Solution213;

/**
 * 337. House Robber III (Medium)
 *
 * @author Kingen
 * @see Solution198
 * @see Solution213
 * @see <a href="https://leetcode-cn.com/problems/house-robber-iii/">House Robber III</a>
 */
public class Solution337 implements Solution {

    /**
     * @see #DFS
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
     */
    public int rob(TreeNode root) {
        return robSubTree(root)[1];
    }

    /**
     * Robs a subtree.
     *
     * @return the max value ignoring the root of the subtree, the max value
     */
    private int[] robSubTree(TreeNode node) {
        int[] res = new int[2];
        if (node.left != null) {
            int[] left = robSubTree(node.left);
            res[0] += left[1];
            res[1] += left[0];
        }
        if (node.right != null) {
            int[] right = robSubTree(node.right);
            res[0] += right[1];
            res[1] += right[0];
        }
        res[1] = Math.max(res[0], node.val + res[1]);
        return res;
    }
}
