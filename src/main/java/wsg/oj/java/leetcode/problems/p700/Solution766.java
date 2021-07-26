package wsg.oj.java.leetcode.problems.p700;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 766. Toeplitz Matrix (EASY)
 *
 * @author Kingen
 * @see Solution422
 * @see <a href="https://leetcode-cn.com/problems/toeplitz-matrix/">Toeplitz Matrix</a>
 * @since 2021-07-26
 */
class Solution766 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] first = matrix[0];
        for (int i = 1; i < m; i++) {
            int[] row = matrix[i];
            for (int j = n - 1; j >= 1; j--) {
                if (row[j] != first[j - 1]) {
                    return false;
                }
                first[j] = row[j];
            }
            first[0] = row[0];
        }
        return true;
    }
}
