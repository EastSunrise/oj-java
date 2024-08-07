package cn.kingen.oj.leetcode.problem.p3000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/modify-the-matrix/">3033. Modify the Matrix</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATRIX},
        difficulty = Difficulty.EASY
)
public class Solution3033 {

    @Complexity(time = "O(m * n)", space = "O(n)")
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] max = new int[n];
        for (int[] row : matrix) {
            for (int j = 0; j < n; j++) {
                max[j] = Math.max(max[j], row[j]);
            }
        }

        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = matrix[i][j] == -1 ? max[j] : matrix[i][j];
            }
        }
        return ans;
    }
}