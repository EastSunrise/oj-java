package cn.kingen.oj.leetcode.problem.p3200;

import static cn.kingen.oj.leetcode.util.MathUtils.MOD;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/find-the-count-of-monotonic-pairs-i/">3250. Find the Count of Monotonic Pairs I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p800.Solution896

 */
@Question(
    tags = {Tag.ARRAY, Tag.MATH, Tag.DYNAMIC_PROGRAMMING, Tag.COMBINATORICS, Tag.PREFIX_SUM},
    difficulty = Difficulty.HARD
)
public class Solution3250 {

    @Complexity(time = "O(n*m^2)", space = "O(n*m)")
    public int countOfPairs(int[] nums) {
        int n = nums.length;
        int m = 0;
        for (int num : nums) {
            m = Math.max(m, num);
        }
        int[][] memo = new int[n][m + 1];
        for (int[] a : memo) {
            Arrays.fill(a, -1);
        }
        // dp[i][j] = dp[i-1][x], 0<=x<=j, nums[i-1]-x>=nums[i]-j
        return dfs(memo, nums, 0, 0, m);
    }

    private int dfs(int[][] memo, int[] nums, int i, int p, int q) {
        if (i == nums.length) {
            return 1;
        }
        if (memo[i][p] != -1) {
            return memo[i][p];
        }
        int count = 0;
        for (int k = Math.max(p, nums[i] - q); k <= nums[i]; k++) {
            count = (count + dfs(memo, nums, i + 1, k, nums[i] - k)) % MOD;
        }
        return memo[i][p] = count;
    }
}