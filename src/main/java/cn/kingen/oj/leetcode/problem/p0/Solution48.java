package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/rotate-image/">48. Rotate Image</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1800.Solution1886
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH, Tag.MATRIX},
        difficulty = Difficulty.MEDIUM
)
public class Solution48 {

    /**
     * Divides the matrix into four parts.
     */
    @Complexity(time = "O(n^2)", space = "O(1)")
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