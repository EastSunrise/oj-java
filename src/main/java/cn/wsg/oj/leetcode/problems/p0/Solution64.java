package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p100.Solution174;
import cn.wsg.oj.leetcode.problems.p700.Solution741;

/**
 * 64. Minimum Path Sum (Medium)
 *
 * @author Kingen
 * @see Solution62
 * @see Solution174
 * @see Solution741
 * @see <a href="https://leetcode-cn.com/problems/minimum-path-sum/">Minimum Path Sum</a>
 */
public class Solution64 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see Complexity#TIME_MN
     * @see Complexity#SPACE_MN
     */
    public int minPathSum(int[][] grid) {
        return dp(grid, grid[0][0], Integer::sum, (dpi, dpj, val) -> Math.min(dpi, dpj) + val);
    }
}
