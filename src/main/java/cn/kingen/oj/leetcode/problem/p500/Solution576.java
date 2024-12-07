package cn.kingen.oj.leetcode.problem.p500;

import static cn.kingen.oj.leetcode.util.MathUtils.MOD;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/out-of-boundary-paths/">576. Out of Boundary Paths</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p600.Solution688
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2120

 */
@Question(
    tags = {Tag.DYNAMIC_PROGRAMMING},
    difficulty = Difficulty.MEDIUM
)
public class Solution576 {

    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    @Complexity(time = "O(kmn)", space = "O(kmn)")
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] memo = new int[maxMove + 1][m][n];
        for (int[][] a : memo) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return dfs(memo, m, n, maxMove, startRow, startColumn);
    }

    private int dfs(int[][][] memo, int m, int n, int k, int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return 1;
        }
        if (k == 0) {
            return 0;
        }
        if (memo[k][x][y] != -1) {
            return memo[k][x][y];
        }

        int count = 0;
        for (int[] d : DIRECTIONS) {
            count = (count + dfs(memo, m, n, k - 1, x + d[0], y + d[1])) % MOD;
        }
        return memo[k][x][y] = count;
    }
}