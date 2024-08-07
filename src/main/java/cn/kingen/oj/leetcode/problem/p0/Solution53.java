package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-subarray/">53. Maximum Subarray</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution121
 * @see cn.kingen.oj.leetcode.problem.p100.Solution152
 * @see cn.kingen.oj.leetcode.problem.p600.Solution697
 * @see cn.kingen.oj.leetcode.problem.p900.Solution978
 */
@Question(
        tags = {Tag.ARRAY, Tag.DIVIDE_AND_CONQUER, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution53 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int maxSubArray(int[] nums) {
        // dp: maximum sum of subarray ending at i
        int dp = 0, ans = Integer.MIN_VALUE;
        for (int num : nums) {
            dp = Math.max(0, dp) + num;
            ans = Math.max(ans, dp);
        }
        return ans;
    }
}