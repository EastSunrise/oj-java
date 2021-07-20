package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 598. Range Addition II (EASY)
 *
 * @author Kingen
 * @see Solution370
 * @see <a href="https://leetcode-cn.com/problems/range-addition-ii/">Range Addition II</a>
 * @since 2021-07-20
 */
class Solution598 implements Solution {

    /**
     * @complexity T=O(l), l=len(ops)
     * @complexity S=O(1)
     */
    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op : ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        return m * n;
    }
}
