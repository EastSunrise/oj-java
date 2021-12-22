package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 Matrix (MEDIUM)
 *
 * @author Kingen
 * @see Solution1730
 * @see <a href="https://leetcode-cn.com/problems/01-matrix/">01 Matrix</a>
 */
class Solution542 implements Solution {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see Complexity#TIME_MN
     * @see Complexity#SPACE_CONSTANT
     */
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    dp[i][j] = 0xfffffff;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j < n - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }

    /**
     * @see #BFS
     * @see Complexity#TIME_MN
     * @see Complexity#SPACE_MN
     */
    public int[][] updateMatrix2(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        for (int[] row : res) {
            Arrays.fill(row, -1);
        }
        Queue<Integer> queue = new LinkedList<>();
        int bits = 16, mask = 0xffff;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    queue.offer((i << bits) + j);
                }
            }
        }

        while (!queue.isEmpty()) {
            int cell = queue.poll();
            int r0 = cell >> bits, c0 = mask & cell;
            for (int i = 0; i < 4; i++) {
                int r = r0 + dr[i], c = c0 + dc[i];
                if (r >= 0 && r < m && c >= 0 && c < n && res[r][c] < 0) {
                    res[r][c] = res[r0][c0] + 1;
                    queue.offer((r << bits) + c);
                }
            }
        }

        return res;
    }
}
