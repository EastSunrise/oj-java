package cn.wsg.oj.leetcode.problems.lcp;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;

/**
 * LCP 34. 二叉树染色 (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/er-cha-shu-ran-se-UGC/">二叉树染色</a>
 */
public class Lcp34 implements Solution {

    /**
     * @complexity T=O(n*k^2), n=the number of nodes
     * @complexity S=O(k*log{n})
     */
    public int maxValue(TreeNode root, int k) {
        int[] sums = dfs(root, k);
        int max = 0;
        for (int sum : sums) {
            max = Math.max(max, sum);
        }
        return max;
    }

    private int[] dfs(TreeNode p, int k) {
        if (p == null) {
            return new int[]{0};
        }
        int[] left = dfs(p.left, k);
        int[] right = dfs(p.right, k);
        int leftCnt = left.length - 1, rightCnt = right.length - 1;
        // the maximal number of blue nodes from the root node of this subtree
        int max = Math.min(leftCnt + rightCnt + 1, k);
        // sums[i]: the maximal sum of this subtree
        // when the number of blue nodes from the root node of this subtree is 'i'
        int[] sums = new int[max + 1];
        for (int l = 0; l <= leftCnt; l++) {
            for (int r = 0; r <= rightCnt; r++) {
                // this node is still white
                sums[0] = Math.max(sums[0], left[l] + right[r]);
                // dye this node blue
                int cnt = l + r + 1;
                if (cnt <= max) {
                    sums[cnt] = Math.max(sums[cnt], left[l] + right[r] + p.val);
                }
            }
        }
        return sums;
    }
}
