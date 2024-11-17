package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-flips-to-make-binary-grid-palindromic-ii/">3240. Minimum Number of Flips to Make Binary Grid Palindromic II</a>
 *
 * @author Kingen

 */
@Question(
    tags = {Tag.ARRAY, Tag.TWO_POINTERS, Tag.MATRIX},
    difficulty = Difficulty.MEDIUM
)
public class Solution3240 {

    @Complexity(time = "O(mn)", space = "O(1)")
    public int minFlips(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int ri = 0, rj = m - 1; ri < rj; ri++, rj--) {
            for (int ci = 0, cj = n - 1; ci < cj; ci++, cj--) {
                int sum = grid[ri][ci] + grid[rj][ci] + grid[ri][cj] + grid[rj][cj];
                ans += Math.min(sum, 4 - sum);
            }
        }
        int onePairs = 0, diff = 0;
        if (m % 2 == 1) {
            int k = m / 2;
            for (int i = 0, j = n - 1; i < j; i++, j--) {
                if (grid[k][i] != grid[k][j]) {
                    diff++;
                } else if (grid[k][i] == 1) {
                    onePairs++;
                }
            }
        }
        if (n % 2 == 1) {
            int k = n / 2;
            for (int i = 0, j = m - 1; i < j; i++, j--) {
                if (grid[i][k] != grid[j][k]) {
                    diff++;
                } else if (grid[i][k] == 1) {
                    onePairs++;
                }
            }
        }
        if (diff == 0 && onePairs % 2 == 1) {
            ans += 2;
        }
        if (m % 2 == 1 && n % 2 == 1 && grid[m / 2][n / 2] == 1) {
            ans++;
        }
        return ans + diff;
    }
}