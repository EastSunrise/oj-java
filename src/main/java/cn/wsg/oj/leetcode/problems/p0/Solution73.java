package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution289;

/**
 * 73. Set Matrix Zeroes (Medium)
 *
 * @author Kingen
 * @see Solution289
 * @see <a href="https://leetcode-cn.com/problems/set-matrix-zeroes/">Set Matrix Zeroes</a>
 */
public class Solution73 implements Solution {

    /**
     * Uses two sides to records whether the row or column will be set to zero.
     *
     * @see Complexity#TIME_MN
     * @see Complexity#SPACE_CONSTANT
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean row0 = false, column0 = false;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                row0 = true;
                break;
            }
        }
        for (int[] rows : matrix) {
            if (rows[0] == 0) {
                column0 = true;
                break;
            }
        }
        // record rows and columns to be changed in first row and column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (column0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
