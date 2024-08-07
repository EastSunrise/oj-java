package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/spiral-matrix-ii/">59. Spiral Matrix II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution54
 * @see cn.kingen.oj.leetcode.problem.p800.Solution885
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2326
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATRIX, Tag.SIMULATION},
        difficulty = Difficulty.MEDIUM
)
public class Solution59 {

    @Complexity(time = "O(n^2)", space = "O(n^2)")
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        // di: the step of i; dj: the step of j
        // len: the count of unvisited elements in this direction
        // turns: times of turning
        int i = 0, j = 0, di = 0, dj = 1, len = n, turns = 0;
        for (int v = 1; len > 0; v++) {
            for (int k = 0; k < len; k++) {
                i += di;
                j += dj;
                ans[i][j] = v;
            }

            turns++; // turn right when reaching the end in this direction
            int tmp = di;
            di = dj;
            dj = -tmp;
            len = (n + n) - len - turns;
        }
        return ans;
    }
}