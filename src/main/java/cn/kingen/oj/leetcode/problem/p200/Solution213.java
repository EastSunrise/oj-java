package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/house-robber-ii/">213. House Robber II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution198
 * @see cn.kingen.oj.leetcode.problem.p200.Solution256
 * @see cn.kingen.oj.leetcode.problem.p200.Solution276
 * @see cn.kingen.oj.leetcode.problem.p300.Solution337
 * @see cn.kingen.oj.leetcode.problem.p600.Solution600
 * @see cn.kingen.oj.leetcode.problem.p600.Solution656
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution213 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(robLinearly(nums, 0, n - 2), robLinearly(nums, 1, n - 1));
    }

    private int robLinearly(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        // dpp: max money after robbing nums[start,i-2]
        // dp: max money after robbing nums[start,i-1]
        int dpp = 0, dp = nums[start], cur;
        for (int i = start + 1; i <= end; i++) {
            cur = Math.max(dpp + nums[i], dp);
            dpp = dp;
            dp = cur;
        }
        return dp;
    }
}