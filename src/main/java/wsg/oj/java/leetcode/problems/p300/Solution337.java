package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;
import wsg.oj.java.leetcode.problems.p100.Solution198;
import wsg.oj.java.leetcode.problems.p200.Solution213;

/**
 * 337. House Robber III (Medium)
 *
 * @author Kingen
 * @see Solution198
 * @see Solution213
 * @see <a href="https://leetcode-cn.com/problems/house-robber-iii/">House Robber III</a>
 * @since 2021-07-04
 */
public class Solution337 extends Solution {

    /**
     * @see #DFS
     * @see #TIME_N
     * @see #SPACE_N
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
