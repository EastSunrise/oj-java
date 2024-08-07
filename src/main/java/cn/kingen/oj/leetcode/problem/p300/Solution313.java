package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/super-ugly-number/">313. Super Ugly Number</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution264
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution313 {

    @Complexity(time = "O(nk)", space = "O(n+k)")
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        long[] dp = new long[n];
        dp[0] = 1;
        // a candidate: the prime, the index of the previous one, the value of the candidate
        int[] pointers = new int[k];
        long[] nums = new long[k];
        Arrays.setAll(nums, i -> primes[i]);
        for (int i = 1; i < n; i++) {
            // find the minimum as the i-th ugly number
            long min = Long.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                min = Math.min(min, nums[j]);
            }
            dp[i] = min;

            // update the candidates
            for (int j = 0; j < k; j++) {
                if (nums[j] == min) {
                    pointers[j]++;
                    nums[j] = dp[pointers[j]] * primes[j];
                }
            }
        }
        return (int) dp[n - 1];
    }
}