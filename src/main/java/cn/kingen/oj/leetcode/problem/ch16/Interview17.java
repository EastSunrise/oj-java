package cn.kingen.oj.leetcode.problem.ch16;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/contiguous-sequence-lcci/">面试题 16.17. Contiguous Sequence LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.DIVIDE_AND_CONQUER, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.EASY
)
public class Interview17 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int dp = nums[0], ans = dp;
        for (int i = 1; i < n; i++) {
            dp = Math.max(nums[i], dp + nums[i]);
            ans = Math.max(ans, dp);
        }
        return ans;
    }
}