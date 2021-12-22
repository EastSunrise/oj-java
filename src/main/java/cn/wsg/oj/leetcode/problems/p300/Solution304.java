package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 304. Range Sum Query 2D - Immutable (Medium)
 *
 * @author Kingen
 * @see Solution303
 * @see Solution308
 * @see <a href="https://leetcode-cn.com/problems/range-sum-query-2d-immutable/">Range Sum Query 2D
 * - Immutable</a>
 */
public class Solution304 implements Solution {

    static class NumMatrix {

        /**
         * sums[i][j]: the sum of the rectangle defined by its upper left corner (0,0) and lower
         * right corner (i,j).
         */
        private final int[][] sums;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            sums = new int[m][n];
            sums[0][0] = matrix[0][0];
            for (int i = 1; i < m; i++) {
                sums[i][0] = matrix[i][0] + sums[i - 1][0];
            }
            for (int j = 1; j < n; j++) {
                sums[0][j] = matrix[0][j] + sums[0][j - 1];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    sums[i][j] =
                        sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = sums[row2][col2];
            if (row1 > 0) {
                sum -= sums[row1 - 1][col2];
            }
            if (col1 > 0) {
                sum -= sums[row2][col1 - 1];
            }
            if (row1 > 0 && col1 > 0) {
                sum += sums[row1 - 1][col1 - 1];
            }
            return sum;
        }
    }
}
