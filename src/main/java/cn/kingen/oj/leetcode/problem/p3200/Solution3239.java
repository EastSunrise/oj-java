package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-flips-to-make-binary-grid-palindromic-i/">3239. Minimum Number of Flips to Make Binary Grid Palindromic I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2193
 */
@Question(
        tags = {Tag.ARRAY, Tag.TWO_POINTERS, Tag.MATRIX},
        difficulty = Difficulty.MEDIUM
)
public class Solution3239 {

    @Complexity(time = "O(mn)", space = "O(1)")
    public int minFlips(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int w = 0, h = 0;
        for (int[] row : grid) {
            for (int j = 0, k = n - 1; j < k; j++, k--) {
                if (row[j] != row[k]) {
                    w++;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0, k = m - 1; i < k; i++, k--) {
                if (grid[i][j] != grid[k][j]) {
                    h++;
                }
            }
        }
        return Math.min(w, h);
    }
}