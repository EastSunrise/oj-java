package cn.kingen.oj.leetcode.problem.p1300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/sort-the-matrix-diagonally/">1329. Sort the Matrix Diagonally</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATRIX, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution1329 {

    @Complexity(time = "O(mn*log{min(m,n)})", space = "O(max(m,n))")
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] tmp = new int[Math.max(m, n) + 1];
        for (int k = 0; k < m; k++) {
            // diagonal from mat[k][0]
            int j = 0, r = Math.min(m - k, n);
            for (; j < r; j++) {
                tmp[j] = mat[j + k][j];
            }
            Arrays.sort(tmp, 0, j);

            j = 0;
            for (; j < r; j++) {
                mat[j + k][j] = tmp[j];
            }
        }
        for (int k = 1; k < n; k++) {
            // diagonal from mat[0][k]
            int i = 0, r = Math.min(m, n - k);
            for (; i < r; i++) {
                tmp[i] = mat[i][i + k];
            }
            Arrays.sort(tmp, 0, i);

            i = 0;
            for (; i < r; i++) {
                mat[i][i + k] = tmp[i];
            }
        }
        return mat;
    }
}