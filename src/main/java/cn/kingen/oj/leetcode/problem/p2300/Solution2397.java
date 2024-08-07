package cn.kingen.oj.leetcode.problem.p2300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-rows-covered-by-columns/">2397. Maximum Rows Covered by Columns</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p400.Solution473
 * @see cn.kingen.oj.leetcode.problem.p600.Solution698
 * @see cn.kingen.oj.leetcode.problem.p900.Solution943
 * @see cn.kingen.oj.leetcode.problem.p1100.Solution1125
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2305
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.BACKTRACKING, Tag.ENUMERATION, Tag.MATRIX},
        difficulty = Difficulty.MEDIUM
)
public class Solution2397 {

    @Complexity(time = "O(m*2^n)", space = "O(m+n)")
    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length, n = matrix[0].length;
        int[] rows = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rows[i] = (rows[i] << 1) + matrix[i][j];
            }
        }
        return dfs(rows, n, 0, numSelect, 0, 0);
    }

    private int dfs(int[] rows, int n, int used, int numSelect, int selected, int mask) {
        if (selected == numSelect) {
            mask <<= (n - used);
            int cnt = 0;
            for (int row : rows) {
                if ((row & mask) == row) {
                    cnt++;
                }
            }
            return cnt;
        }
        if (n - used < numSelect - selected) {
            return 0;
        }
        int maxSelected = dfs(rows, n, used + 1, numSelect, selected + 1, (mask << 1) + 1);
        int maxUnselected = dfs(rows, n, used + 1, numSelect, selected, mask << 1);
        return Math.max(maxSelected, maxUnselected);
    }
}