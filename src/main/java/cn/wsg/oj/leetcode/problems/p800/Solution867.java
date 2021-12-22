package cn.wsg.oj.leetcode.problems.p800;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 867. Transpose Matrix (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/transpose-matrix/">Transpose Matrix</a>
 */
public class Solution867 implements Solution {

    /**
     * @see Complexity#TIME_MN
     * @see Complexity#SPACE_MN
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
