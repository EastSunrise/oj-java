package cn.kingen.oj.leetcode.problem.p1700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/where-will-the-ball-fall/">1706. Where Will the Ball Fall</a>
 *
 * @author Kingen

 */
@Question(
    tags = {Tag.ARRAY, Tag.MATRIX, Tag.SIMULATION},
    difficulty = Difficulty.MEDIUM,
    date = "2025-02-15"
)
public class Solution1706 {

    @Complexity(time = "O(m * n)", space = "O(1)")
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] ans = new int[n];
        for (int k = 0; k < n; k++) {
            int i = 0, j = k, side = 0; // the side where the ball is coming from, left=1, right=-1, top=0
            while (i >= 0 && i < m && j >= 0 && j < n) {
                if (side == 0) { // column is changed
                    side = grid[i][j];
                    j += grid[i][j];
                } else if (side == grid[i][j]) { // next row if two boards are parallel
                    side = 0;
                    i++;
                } else {
                    break;
                }
            }
            ans[k] = i == m ? j : -1;
        }
        return ans;
    }
}