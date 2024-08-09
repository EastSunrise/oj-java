package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/design-neighbor-sum-service/">3242. Design Neighbor Sum Service</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1300.Solution1314
 * @see cn.kingen.oj.leetcode.problem.p1900.Solution1968
 */
@Question(
        tags = {Tag.DESIGN, Tag.ARRAY, Tag.HASH_TABLE, Tag.MATRIX, Tag.SIMULATION},
        difficulty = Difficulty.EASY
)
public class neighborSum {

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static final int[][] DIAGONALS = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    private final int[][] sums;

    @Complexity(time = "O(n^2)", space = "O(n^2)")
    public neighborSum(int[][] grid) {
        int n = grid.length;
        this.sums = new int[n * n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                for (int[] d : DIRECTIONS) {
                    int x = i + d[0], y = j + d[1];
                    if (x >= 0 && x < n && y >= 0 && y < n) {
                        sums[val][0] += grid[x][y];
                    }
                }
                for (int[] d : DIAGONALS) {
                    int x = i + d[0], y = j + d[1];
                    if (x >= 0 && x < n && y >= 0 && y < n) {
                        sums[val][1] += grid[x][y];
                    }
                }
            }
        }
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public int adjacentSum(int value) {
        return sums[value][0];
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public int diagonalSum(int value) {
        return sums[value][1];
    }
}