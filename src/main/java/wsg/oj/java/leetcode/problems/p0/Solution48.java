package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 48. Rotate Image (Medium)
 *
 * @author Kingen
 * @see Solution1886
 * @see <a href="https://leetcode-cn.com/problems/rotate-image/">Rotate Image</a>
 * @since 2021-07-11
 */
public class Solution48 implements Solution {

    /**
     * Divides the matrix into four parts.
     *
     * @see wsg.oj.java.Complexity#TIME_NN
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int n = len - 1;
        // rotate quarter of the matrix four times
        for (int i = 0, iLen = (len + 1) / 2; i < iLen; i++) {
            for (int j = 0, jLen = len / 2; j < jLen; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[j][n - i];
                matrix[j][n - i] = temp;
            }
        }
    }
}
