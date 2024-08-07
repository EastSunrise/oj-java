package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-iv/">377. Combination Sum IV</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution39
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution377 {

    @Complexity(time = "O(n*m)", space = "O(m)", note = "n is the length of nums, m is the target")
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}