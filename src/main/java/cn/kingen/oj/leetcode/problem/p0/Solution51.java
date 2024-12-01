package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/n-queens/">51. N-Queens</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution52
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1001

 */
@Question(
    tags = {Tag.ARRAY, Tag.BACKTRACKING},
    difficulty = Difficulty.HARD
)
public class Solution51 {

    @Complexity(time = "O(n!)", space = "O(n)")
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        dfs(ans, n, board, new boolean[n], new boolean[2 * n], new boolean[2 * n], n - 1);
        return ans;
    }

    private void dfs(List<List<String>> ans, int n, char[][] board, boolean[] col, boolean[] slash, boolean[] backslash,
        int i) {
        if (i < 0) {
            List<String> list = new ArrayList<>(n);
            for (char[] row : board) {
                list.add(new String(row));
            }
            ans.add(list);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (col[j] || slash[i + j] || backslash[j - i + n]) {
                continue;
            }
            board[i][j] = 'Q';
            col[j] = slash[i + j] = backslash[j - i + n] = true;
            dfs(ans, n, board, col, slash, backslash, i - 1);
            col[j] = slash[i + j] = backslash[j - i + n] = false;
            board[i][j] = '.';
        }
    }
}