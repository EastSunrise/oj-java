package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/n-queens-ii/">52. N-Queens II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution51

 */
@Question(
    tags = {Tag.BACKTRACKING},
    difficulty = Difficulty.HARD
)
public class Solution52 {

    @Complexity(time = "O(n!)", space = "O(n)")
    public int totalNQueens(int n) {
        return dfs(n, new boolean[n], new boolean[2 * n], new boolean[2 * n], n - 1);
    }

    private int dfs(int n, boolean[] col, boolean[] slash, boolean[] backslash, int i) {
        if (i < 0) {
            return 1;
        }

        int count = 0;
        for (int j = 0; j < n; j++) {
            if (col[j] || slash[i + j] || backslash[j - i + n]) {
                continue;
            }
            col[j] = slash[i + j] = backslash[j - i + n] = true;
            count += dfs(n, col, slash, backslash, i - 1);
            col[j] = slash[i + j] = backslash[j - i + n] = false;
        }
        return count;
    }
}