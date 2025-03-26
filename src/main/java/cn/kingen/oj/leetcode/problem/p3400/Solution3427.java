package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/sum-of-variable-length-subarrays/">3427. Sum of Variable Length Subarrays</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.NumArray
 * @see cn.kingen.oj.leetcode.problem.p600.Solution689

 */
@Question(
        tags = {Tag.ARRAY, Tag.PREFIX_SUM},
        difficulty = Difficulty.EASY,
        contest = 433
)
public class Solution3427 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int subarraySum(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
            ans += prefix[i + 1] - prefix[Math.max(0, i - nums[i])];
        }
        return ans;
    }
}