package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

import static cn.kingen.oj.leetcode.util.MathUtils.MOD;
import static cn.kingen.oj.leetcode.util.MathUtils.fastPow;

/**
 * <a href="https://leetcode.cn/problems/maximum-and-minimum-sums-of-at-most-size-k-subsequences/">3428. Maximum and Minimum Sums of at Most Size K Subsequences</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH, Tag.DYNAMIC_PROGRAMMING, Tag.COMBINATORICS, Tag.SORTING},
        difficulty = Difficulty.MEDIUM,
        contest = 433
)
public class Solution3428 {

    private static final int MX = 100_000;
    private static final long[] FACTORIAL = new long[MX];
    private static final long[] INVERSE = new long[MX];

    static {
        FACTORIAL[0] = 1;
        for (int i = 1; i < MX; i++) {
            FACTORIAL[i] = FACTORIAL[i - 1] * i % MOD;
        }

        INVERSE[MX - 1] = fastPow(FACTORIAL[MX - 1], MOD - 2, MOD);
        for (int i = MX - 2; i >= 0; i--) {
            INVERSE[i] = INVERSE[i + 1] * (i + 1) % MOD;
        }
    }

    @Complexity(time = "O(n*log(n))", space = "O(1)")
    public int minMaxSums(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long sum = 1;
            for (int j = 1, m = Math.min(i, k - 1); j <= m; j++) {
                sum += FACTORIAL[i] * INVERSE[j] % MOD * INVERSE[i - j] % MOD;
            }
            ans += sum % MOD * (nums[i] + nums[n - i - 1]) % MOD;
        }
        return (int) (ans % MOD);
    }
}