package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/magic-squares-in-grid/">840. Magic Squares In Grid</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1800.Solution1895
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.MATH, Tag.MATRIX},
        difficulty = Difficulty.MEDIUM
)
public class Solution840 {

    @Complexity(time = "O(m*n)", space = "O(1)")
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int right = 2; right < m; right++) {
            for (int bottom = 2; bottom < n; bottom++) {
                if (isMagic(grid, right - 2, right, bottom - 2, bottom)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isMagic(int[][] grid, int rs, int re, int cs, int ce) {
        if (grid[rs + 1][cs + 1] != 5) {
            return false;
        }
        int mask = 0;
        for (int i = rs; i <= re; i++) {
            for (int j = cs; j <= ce; j++) {
                int v = grid[i][j], bit = 1 << v;
                if (v < 1 || v > 9 || (mask & bit) != 0) { // 1 <= v <= 9 and v is unique
                    return false;
                }
                mask |= bit;
            }
        }
        int a = grid[rs][cs], b = grid[rs][cs + 1], c = grid[rs][cs + 2];
        int d = grid[rs + 1][cs], e = grid[rs + 1][cs + 1], f = grid[rs + 1][cs + 2];
        int g = grid[rs + 2][cs], h = grid[rs + 2][cs + 1], i = grid[rs + 2][cs + 2];
        return a + b + c == 15 && d + e + f == 15 && g + h + i == 15 &&
                a + d + g == 15 && b + e + h == 15 && c + f + i == 15 &&
                a + e + i == 15 && c + e + g == 15;
    }
}