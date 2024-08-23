package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

import static cn.kingen.oj.leetcode.util.MathUtils.MOD;

/**
 * <a href="https://leetcode.cn/problems/student-attendance-record-ii/">552. Student Attendance Record II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p500.Solution551
 */
@Question(
        tags = {Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD
)
public class Solution552 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int checkRecord(int n) {
        // dp[i][a][l]: count of attendance records of length i,
        // with a-days absence and l-days late at the end
        int[][] dp = new int[2][3], next = new int[2][3];
        dp[0][0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(next[j], 0);
            }

            next[0][0] = ((dp[0][0] + dp[0][1]) % MOD + dp[0][2]) % MOD;
            next[0][1] = dp[0][0];
            next[0][2] = dp[0][1];
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    next[1][0] = (next[1][0] + dp[j][k]) % MOD;
                }
            }
            next[1][1] = dp[1][0];
            next[1][2] = dp[1][1];
            int[][] tmp = dp;
            dp = next;
            next = tmp;
        }
        return dp[1][0] % MOD;
    }
}