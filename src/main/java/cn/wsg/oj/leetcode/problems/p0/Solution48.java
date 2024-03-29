package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p1800.Solution1886;

/**
 * 48. Rotate Image (Medium)
 *
 * @author Kingen
 * @see Solution1886
 * @see <a href="https://leetcode-cn.com/problems/rotate-image/">Rotate Image</a>
 */
public class Solution48 implements Solution {

    /**
     * Divides the matrix into four parts.
     *
     * @see Complexity#TIME_NN
     * @see Complexity#SPACE_CONSTANT
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        // rotate quarter of the matrix four times
        for (int i = 0, iLen = n / 2 + 1; i < iLen; i++) {
            for (int j = 0, jLen = (n + 1) / 2; j < jLen; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[j][n - i];
                matrix[j][n - i] = temp;
            }
        }
    }
}
