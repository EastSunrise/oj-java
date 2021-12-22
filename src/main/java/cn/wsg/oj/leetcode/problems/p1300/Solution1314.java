package cn.wsg.oj.leetcode.problems.p1300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 1314. Matrix Block Sum (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/matrix-block-sum/">Matrix Block Sum</a>
 */
public class Solution1314 implements Solution {

    /**
     * @see Complexity#TIME_MN
     * @see Complexity#SPACE_MN
     */
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] tmp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int dc = 0; dc <= k && dc < n; dc++) {
                tmp[i][0] += mat[i][dc];
            }
            for (int j = 1; j < n; j++) {
                tmp[i][j] = tmp[i][j - 1];
                if (j > k) {
                    tmp[i][j] -= mat[i][j - k - 1];
                }
                if (j + k < n) {
                    tmp[i][j] += mat[i][j + k];
                }
            }
        }
        int[][] res = new int[m][n];
        for (int j = 0; j < n; j++) {
            for (int dr = 0; dr <= k && dr < m; dr++) {
                res[0][j] += tmp[dr][j];
            }
            for (int i = 1; i < m; i++) {
                res[i][j] = res[i - 1][j];
                if (i > k) {
                    res[i][j] -= tmp[i - k - 1][j];
                }
                if (i + k < m) {
                    res[i][j] += tmp[i + k][j];
                }
            }
        }
        return res;
    }
}
