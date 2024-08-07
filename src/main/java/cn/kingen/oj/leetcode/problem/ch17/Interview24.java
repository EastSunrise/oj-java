package cn.kingen.oj.leetcode.problem.ch17;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/max-submatrix-lcci/">面试题 17.24. Max Submatrix LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.MATRIX, Tag.PREFIX_SUM},
        difficulty = Difficulty.HARD
)
public class Interview24 {

    @Complexity(time = "O(m^2*n)", space = "O(1)")
    public int[] getMaxMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] += matrix[i - 1][j];
            }
        }
        int max = Integer.MIN_VALUE;
        int[] ans = new int[4];
        for (int t = 0; t < m; t++) {
            for (int b = t; b < m; b++) {
                // dp: the max sum of sub-matrix
                // with the top-left corner at (t, l) and the bottom-right corner at (b, r)
                int dp = -1;
                for (int l = 0, r = 0; r < n; r++) {
                    if (dp > 0) {
                        dp = dp + matrix[b][r] - (t == 0 ? 0 : matrix[t - 1][r]);
                    } else {
                        dp = matrix[b][r] - (t == 0 ? 0 : matrix[t - 1][r]);
                        l = r;
                    }
                    if (dp > max) {
                        max = dp;
                        ans[0] = t;
                        ans[1] = l;
                        ans[2] = b;
                        ans[3] = r;
                    }
                }
            }
        }
        return ans;
    }
}