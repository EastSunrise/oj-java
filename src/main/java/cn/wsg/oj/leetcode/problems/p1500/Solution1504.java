package cn.wsg.oj.leetcode.problems.p1500;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 1504. Count Submatrices With All Ones (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/count-submatrices-with-all-ones/">Count
 * Submatrices With All Ones</a>
 */
public class Solution1504 implements Solution {

    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int total = 0;
        // indices of increasing heights
        // the count of rectangles with [i,j] as the bottom-right corner
        int[] indices = new int[n + 1], counts = new int[n + 1];
        indices[0] = -1;
        for (int i = 0; i < m; i++) {
            if (i > 0) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1) {
                        mat[i][j] = mat[i - 1][j] + 1;
                    }
                }
            }
            // the last index
            int k = 0;
            for (int j = 0; j < n; j++) {
                while (k > 0 && mat[i][indices[k]] >= mat[i][j]) {
                    k--;
                }
                indices[++k] = j;
                counts[k] = counts[k - 1] + (j - indices[k - 1]) * mat[i][j];
                total += counts[k];
            }
        }
        return total;
    }
}
