package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/knight-probability-in-chessboard/">688. Knight Probability in Chessboard</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p500.Solution576
 * @see cn.kingen.oj.leetcode.problem.p3200.Solution3283

 */
@Question(
    tags = {Tag.DYNAMIC_PROGRAMMING},
    difficulty = Difficulty.MEDIUM
)
public class Solution688 {

    private static final int[][] DIRECTIONS = new int[][]{
        {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
        {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
    };

    @Complexity(time = "O(k*n^2)", space = "O(k*n^2)")
    public double knightProbability(int n, int k, int row, int column) {
        return dfs(new double[k + 1][n][n], n, k, row, column);
    }

    private double dfs(double[][][] memo, int n, int k, int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (memo[k][x][y] != 0) {
            return memo[k][x][y];
        }

        double p = 0;
        for (int[] d : DIRECTIONS) {
            p += dfs(memo, n, k - 1, x + d[0], y + d[1]);

        }
        return memo[k][x][y] = p / 8;
    }
}