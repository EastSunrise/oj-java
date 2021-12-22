package cn.wsg.oj.leetcode.problems.p1300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.List;

/**
 * 1301. Number of Paths with Max Score (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/number-of-paths-with-max-score/">Number of Paths
 * with Max Score</a>
 */
public class Solution1301 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see Complexity#TIME_NN
     * @see Complexity#SPACE_NN
     */
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        // dp[i][j]: the maximal score from (0,0) to (i,j)
        int[][] dp = new int[n][n];
        // counts[i][j]: the count of the maximal dp from (0,0) to (i,j)
        int[][] counts = new int[n][n];
        dp[0][0] = 0;
        counts[0][0] = 1;
        for (int i = 1; i < n; i++) {
            char ch = board.get(i).charAt(0);
            if (ch != 'X' && counts[i - 1][0] != 0) {
                dp[i][0] = dp[i - 1][0] + ch - '0';
                counts[i][0] = counts[i - 1][0];
            }
        }
        for (int j = 1; j < n; j++) {
            char ch = board.get(0).charAt(j);
            if (ch != 'X' && counts[0][j - 1] != 0) {
                dp[0][j] = dp[0][j - 1] + ch - '0';
                counts[0][j] = counts[0][j - 1];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                char ch = board.get(i).charAt(j);
                if (ch == 'X') {
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i][j - 1], dp[i - 1][j]));
                if (dp[i][j] == dp[i - 1][j - 1]) {
                    counts[i][j] = (counts[i][j] + counts[i - 1][j - 1]) % MOD;
                }
                if (dp[i][j] == dp[i][j - 1]) {
                    counts[i][j] = (counts[i][j] + counts[i][j - 1]) % MOD;
                }
                if (dp[i][j] == dp[i - 1][j]) {
                    counts[i][j] = (counts[i][j] + counts[i - 1][j]) % MOD;
                }
                dp[i][j] += ch - '0';
            }
        }
        if (counts[n - 1][n - 1] == 0) {
            return new int[]{0, 0};
        }
        return new int[]{dp[n - 1][n - 1] - 'S' + '0', counts[n - 1][n - 1]};
    }
}
