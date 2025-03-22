package cn.kingen.oj.leetcode.problem.p2600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/row-with-maximum-ones/">2643. Row With Maximum Ones</a>
 *
 * @author Kingen

 */
@Question(
    tags = {Tag.ARRAY, Tag.MATRIX},
    difficulty = Difficulty.EASY,
    date = "2025-03-22"
)
public class Solution2643 {

    @Complexity(time = "O(m * n)", space = "O(1)")
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int max = 0, row = 0;
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count += mat[i][j];
            }
            if (count > max) {
                max = count;
                row = i;
            }
        }
        return new int[]{row, max};
    }
}