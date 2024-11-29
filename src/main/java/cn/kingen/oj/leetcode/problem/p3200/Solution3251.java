package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

import static cn.kingen.oj.leetcode.util.MathUtils.MOD;

/**
 * <a href="https://leetcode.cn/problems/find-the-count-of-monotonic-pairs-ii/">3251. Find the Count of Monotonic Pairs II</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH, Tag.DYNAMIC_PROGRAMMING, Tag.COMBINATORICS, Tag.PREFIX_SUM},
        difficulty = Difficulty.HARD
)
public class Solution3251 {

    /**
     * Assumes that {@code f[i][j]} is the count of pairs when {@code arr1[i] = j}
     * and {@code dp} is the prefix sum of {@code f} which means {@code dp[i][j] = f[i][0] + ... + f[i][j]}.
     * <p>
     * Then {@code f[i][j] = f[i-1][0] + ... + f[i-1][k] = dp[i][k], k<=j && nums[i-1]-k>=nums[i]-j}
     */
    @Complexity(time = "O(nm)", space = "O(nm)")
    public int countOfPairs(int[] nums) {
        int n = nums.length;
        int m = 0;
        for (int num : nums) {
            m = Math.max(m, num);
        }

        int[][] dp = new int[n][m + 1];
        Arrays.setAll(dp[0], j -> j <= nums[0] ? j + 1 : 0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = nums[i - 1] - nums[i] >= 0 ? dp[i - 1][0] : 0;
            for (int j = 1; j <= nums[i]; j++) {
                int max = Math.min(j, nums[i - 1] - nums[i] + j); // max of k
                dp[i][j] = max >= 0 ? (dp[i][j - 1] + dp[i - 1][max]) % MOD : 0;
            }
            for (int j = nums[i] + 1; j <= m; j++) { // f[i][j] = 0, fill prefix sums
                dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[n - 1][m];
    }
}