package cn.kingen.oj.leetcode.problem.p900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/knight-dialer/">935. Knight Dialer</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution935 {

    private static final int[][] NEIGHBORS = new int[][]{
            {4, 6},
            {6, 8},
            {7, 9},
            {4, 8},
            {0, 3, 9},
            {},
            {0, 1, 7},
            {2, 6},
            {1, 3},
            {2, 4}
    };

    @Complexity(time = "O(kn)", space = "O(kn)", note = "k is 10")
    public int knightDialer(int n) {
        int[][] dp = new int[n + 1][10];
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= n; i++) {
            for (int x = 0; x < 10; x++) {
                for (int y : NEIGHBORS[x]) {
                    dp[i][x] = (dp[i][x] + dp[i - 1][y]) % 1_000_000_007;
                }
            }
        }
        int ans = 0;
        for (int x = 0; x < 10; x++) {
            ans = (ans + dp[n][x]) % 1_000_000_007;
        }
        return ans;
    }
}