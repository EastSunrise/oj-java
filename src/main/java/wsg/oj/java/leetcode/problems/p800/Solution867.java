package wsg.oj.java.leetcode.problems.p800;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 867. Transpose Matrix (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/transpose-matrix/">Transpose Matrix</a>
 * @since 2021-07-27
 */
public class Solution867 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_MN
     */
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
