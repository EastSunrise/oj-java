package cn.kingen.oj.leetcode.problem.p3000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-ii/">3040. Maximum Number of Operations With the Same Score II</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.MEMOIZATION, Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution3040 {

    @Complexity(time = "O(n^2)", space = "O(n^2)")
    public int maxOperations(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        int max = 1 + dfs(memo, nums, nums[0] + nums[1], 2, n - 1);
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        max = Math.max(max, 1 + dfs(memo, nums, nums[n - 1] + nums[n - 2], 0, n - 3));
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        max = Math.max(max, 1 + dfs(memo, nums, nums[0] + nums[n - 1], 1, n - 2));
        return max;
    }

    public int dfs(int[][] memo, int[] nums, int score, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int max = 0;
        if (nums[i] + nums[i + 1] == score) {
            max = 1 + dfs(memo, nums, score, i + 2, j);
        }
        if (nums[j] + nums[j - 1] == score) {
            max = Math.max(max, 1 + dfs(memo, nums, score, i, j - 2));
        }
        if (nums[i] + nums[j] == score) {
            max = Math.max(max, 1 + dfs(memo, nums, score, i + 1, j - 1));
        }
        memo[i][j] = max;
        return max;
    }
}