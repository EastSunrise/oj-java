package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 64. Minimum Path Sum (Medium)
 *
 * @author Kingen
 * @see Solution62
 * @see Solution174
 * @see Solution741
 * @see <a href="https://leetcode-cn.com/problems/minimum-path-sum/">Minimum Path Sum</a>
 * @since 2021-07-11
 */
class Solution64 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_MN
     */
    public int minPathSum(int[][] grid) {
        return dp(grid, grid[0][0], Integer::sum, (dpi, dpj, val) -> Math.min(dpi, dpj) + val);
    }
}
