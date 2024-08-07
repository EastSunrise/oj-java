package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;


/**
 * <a href="https://leetcode.cn/problems/house-robber/">198. House Robber</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution152
 * @see cn.kingen.oj.leetcode.problem.p200.Solution213
 * @see cn.kingen.oj.leetcode.problem.p200.Solution256
 * @see cn.kingen.oj.leetcode.problem.p200.Solution276
 * @see cn.kingen.oj.leetcode.problem.p300.Solution337
 * @see cn.kingen.oj.leetcode.problem.p600.Solution600
 * @see cn.kingen.oj.leetcode.problem.p600.Solution656
 * @see cn.kingen.oj.leetcode.problem.p700.Solution740
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution198 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        // dpp: max money after robbing nums[0,i-2]
        // dp: max money after robbing nums[0,i-1]
        int dpp = 0, dp = nums[0], cur;
        for (int i = 1; i < n; i++) {
            cur = Math.max(dpp + nums[i], dp);
            dpp = dp;
            dp = cur;
        }
        return dp;
    }
}