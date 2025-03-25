package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/difference-of-number-of-distinct-values-on-diagonals/">2711. Difference of Number of Distinct Values on Diagonals</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.MATRIX},
        difficulty = Difficulty.MEDIUM,
        date = "2025-03-25"
)
public class Solution2711 {

    @Complexity(time = "O(m * n)", space = "O(m * n)")
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m][n];
        for (int r = 0; r < m; r++) {
            traverseDiagonal(grid, ans, m, n, r, 0);
        }
        for (int c = 1; c < n; c++) {
            traverseDiagonal(grid, ans, m, n, 0, c);
        }
        return ans;
    }

    private void traverseDiagonal(int[][] grid, int[][] ans, int m, int n, int r, int c) {
        int cnt = 0;
        int[] freq = new int[51];
        int i = r, j = c;
        for (; i < m && j < n; i++, j++) {
            ans[i][j] = cnt;
            if (freq[grid[i][j]]++ == 0) { // first occurrence
                cnt++;
            }
        }
        cnt = 0;
        Arrays.fill(freq, 0);
        for (i--, j--; i >= r && j >= c; i--, j--) {
            ans[i][j] = Math.abs(ans[i][j] - cnt);
            if (freq[grid[i][j]]++ == 0) { // first occurrence
                cnt++;
            }
        }
    }
}