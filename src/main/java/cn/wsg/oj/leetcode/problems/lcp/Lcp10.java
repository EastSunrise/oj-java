package cn.wsg.oj.leetcode.problems.lcp;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;

/**
 * LCP 10. 二叉树任务调度 (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/er-cha-shu-ren-wu-diao-du/">二叉树任务调度</a>
 */
public class Lcp10 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
     */
    public double minimalExecTime(TreeNode root) {
        double[] t = dfs(root);
        return t[0] - t[1];
    }

    private double[] dfs(TreeNode p) {
        if (p == null) {
            return new double[]{0.0, 0.0};
        }

        double[] left = dfs(p.left);
        double[] right = dfs(p.right);
        if (left[0] < right[0]) {
            double[] tmp = left;
            left = right;
            right = tmp;
        }

        double pt;
        if (left[0] - right[0] < 2 * left[1]) {
            pt = (left[0] - right[0]) / 2 + right[0];
        } else {
            pt = left[1] + right[0];
        }
        return new double[]{left[0] + right[0] + p.val, pt};
    }
}
