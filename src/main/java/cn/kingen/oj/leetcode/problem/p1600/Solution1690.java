package cn.kingen.oj.leetcode.problem.p1600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/stone-game-vii/">1690. Stone Game VII</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p800.Solution877
 * @see cn.kingen.oj.leetcode.problem.p1100.Solution1140
 * @see cn.kingen.oj.leetcode.problem.p1400.Solution1406
 * @see cn.kingen.oj.leetcode.problem.p1500.Solution1510
 * @see cn.kingen.oj.leetcode.problem.p1500.Solution1563
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1686
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1770
 * @see cn.kingen.oj.leetcode.problem.p1800.Solution1872
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2029
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH, Tag.DYNAMIC_PROGRAMMING, Tag.GAME_THEORY},
        difficulty = Difficulty.MEDIUM
)
public class Solution1690 {

    @Complexity(time = "O(n^2)", space = "O(n)")
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] += sums[i] + stones[i];
        }
        int[] dp = new int[n];
        for (int k = 2; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                dp[i] = Math.max(sums[i + k] - sums[i + 1] - dp[i + 1], sums[i + k - 1] - sums[i] - dp[i]);
            }
        }
        return dp[0];
    }
}