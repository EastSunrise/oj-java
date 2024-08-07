package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.MathUtils.MOD;

/**
 * <a href="https://leetcode.cn/problems/find-all-possible-stable-binary-arrays-i/">3129. Find All Possible Stable Binary Arrays I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p500.Solution525
 * @see cn.kingen.oj.leetcode.problem.p900.Solution930
 */
@Question(
        tags = {Tag.DYNAMIC_PROGRAMMING, Tag.PREFIX_SUM},
        difficulty = Difficulty.MEDIUM
)
public class Solution3129 {

    @Complexity(time = "O(Z * O)", space = "O(Z * O)")
    public int numberOfStableArrays(int zero, int one, int limit) {
        int[][][] dp = new int[zero + 1][one + 1][2];
        for (int i = 0, k = Math.min(zero, limit); i <= k; i++) {
            dp[i][0][0] = 1;
        }
        for (int j = 0, k = Math.min(one, limit); j <= k; j++) {
            dp[0][j][1] = 1;
        }
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                if (i <= limit) {
                    dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
                } else { // except consecutive limit 0s
                    dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1] - dp[i - limit - 1][j][1];
                }
                dp[i][j][0] = (dp[i][j][0] % MOD + MOD) % MOD;

                if (j <= limit) {
                    dp[i][j][1] = dp[i][j - 1][0] + dp[i][j - 1][1];
                } else { // except consecutive limit 1s
                    dp[i][j][1] = dp[i][j - 1][0] + dp[i][j - 1][1] - dp[i][j - limit - 1][0];
                }
                dp[i][j][1] = (dp[i][j][1] % MOD + MOD) % MOD;
            }
        }
        return (dp[zero][one][0] + dp[zero][one][1]) % MOD;
    }
}