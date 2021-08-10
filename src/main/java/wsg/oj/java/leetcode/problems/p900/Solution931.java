package wsg.oj.java.leetcode.problems.p900;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 931. Minimum Falling Path Sum (MEDIUM)
 *
 * @author Kingen
 * @see Solution1289
 * @see <a href="https://leetcode-cn.com/problems/minimum-falling-path-sum/">Minimum Falling Path
 * Sum</a>
 * @since 2021-07-27
 */
public class Solution931 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_NN
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        for (int i = 1; i < n; i++) {
            matrix[i][0] += Math.min(matrix[i - 1][0], matrix[i - 1][1]);
            for (int j = 1; j < n - 1; j++) {
                int min = Math.min(matrix[i - 1][j - 1], matrix[i - 1][j + 1]);
                matrix[i][j] += Math.min(min, matrix[i - 1][j]);
            }
            matrix[i][n - 1] += Math.min(matrix[i - 1][n - 2], matrix[i - 1][n - 1]);
        }
        return Arrays.stream(matrix[n - 1]).min().orElseThrow();
    }
}
