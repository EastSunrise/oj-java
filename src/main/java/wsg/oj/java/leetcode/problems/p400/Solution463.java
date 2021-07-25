package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p600.Solution695;

/**
 * 463. Island Perimeter (Easy)
 *
 * @author Kingen
 * @see Solution695
 * @see Solution733
 * @see Solution1034
 * @see <a href="https://leetcode-cn.com/problems/island-perimeter/">Island Perimeter</a>
 * @since 2021-07-14
 */
public class Solution463 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int islandPerimeter(int[][] grid) {
        int m = grid.length - 1, n = grid[0].length - 1, perimeter = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (grid[i][j] == 1) {
                    int count = 0;
                    if (i == 0 || grid[i - 1][j] == 0) {
                        count++;
                    }
                    if (i == m || grid[i + 1][j] == 0) {
                        count++;
                    }
                    if (j == 0 || grid[i][j - 1] == 0) {
                        count++;
                    }
                    if (j == n || grid[i][j + 1] == 0) {
                        count++;
                    }
                    perimeter += count;
                }
            }
        }
        return perimeter;
    }
}
