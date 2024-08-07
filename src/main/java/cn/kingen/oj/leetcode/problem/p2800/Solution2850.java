package cn.kingen.oj.leetcode.problem.p2800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/minimum-moves-to-spread-stones-over-grid/">2850. Minimum Moves to Spread Stones Over Grid</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1769
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2998
 */
@Question(
        tags = {Tag.BREADTH_FIRST_SEARCH, Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.MATRIX},
        difficulty = Difficulty.MEDIUM
)
public class Solution2850 {

    @Complexity(time = "O(n!)", space = "O(n^2)")
    public int minimumMoves(int[][] grid) {
        List<int[]> noneCells = new ArrayList<>(8), multiCells = new ArrayList<>(4);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 0) {
                    noneCells.add(new int[]{i, j, 0});
                } else if (grid[i][j] > 1) {
                    multiCells.add(new int[]{i, j, grid[i][j]});
                }
            }
        }
        return dfs(multiCells, noneCells, noneCells.size() - 1);
    }

    private int dfs(List<int[]> multiCells, List<int[]> noneCells, int i) {
        if (i < 0) {
            return 0;
        }
        int minSteps = Integer.MAX_VALUE;
        int x = noneCells.get(i)[0], y = noneCells.get(i)[1];
        for (int[] cell : multiCells) {
            if (cell[2] > 1) { // move a stone from this cell to noneCells[i]
                cell[2]--;
                int steps = dfs(multiCells, noneCells, i - 1);
                minSteps = Math.min(minSteps, steps + Math.abs(x - cell[0]) + Math.abs(y - cell[1]));
                cell[2]++;
            }
        }
        return minSteps;
    }
}