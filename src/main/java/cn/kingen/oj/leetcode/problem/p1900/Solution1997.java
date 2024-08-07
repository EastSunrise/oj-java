package cn.kingen.oj.leetcode.problem.p1900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.MathUtils.MOD;

/**
 * <a href="https://leetcode.cn/problems/first-day-where-you-have-been-in-all-the-rooms/">1997. First Day Where You Have Been in All the Rooms</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution1997 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        // dp[i]: prefix sums of days between an odd day at room i and the odd day at room i+1
        int[] dp = new int[n];
        dp[0] = 2;
        for (int i = 1; i < n - 1; i++) {
            int j = nextVisit[i];
            dp[i] = (dp[i - 1] + 2 + (j > 0 ? (MOD - dp[j - 1]) : 0)) % MOD;
            dp[i] = (dp[i - 1] + dp[i]) % MOD;
        }
        return dp[n - 2];
    }
}