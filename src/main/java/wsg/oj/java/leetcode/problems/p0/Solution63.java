package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 63. Unique Paths II (Medium)
 *
 * @author Kingen
 * @see Solution62
 * @see Solution980
 * @see <a href="https://leetcode-cn.com/problems/unique-paths-ii/">Unique Paths II</a>
 * @since 2021-07-11
 */
public class Solution63 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_MN
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        return dp(obstacleGrid, 1,
            (dpi, obstacle) -> obstacle == 1 ? 0 : dpi,
            (dpi, dpj, obstacle) -> obstacle == 1 ? 0 : dpi + dpj);
    }
}
