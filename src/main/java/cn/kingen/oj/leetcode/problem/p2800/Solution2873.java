package cn.kingen.oj.leetcode.problem.p2800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-value-of-an-ordered-triplet-i/">2873. Maximum Value of an Ordered
 * Triplet I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2367
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2908
 */
@Question(
    tags = {Tag.ARRAY},
    difficulty = Difficulty.EASY,
    date = "2025-04-02"
)
public class Solution2873 {

    @Complexity(time = "O(n)", space = "O(n)")
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] maxRight = new int[n];
        maxRight[n - 1] = nums[n - 1];
        for (int k = n - 2; k >= 0; k--) {
            maxRight[k] = Math.max(maxRight[k + 1], nums[k]);
        }

        long ans = 0;
        int maxLeft = nums[0];
        for (int j = 1; j < n - 1; j++) {
            ans = Math.max(ans, (maxLeft - nums[j]) * (long) maxRight[j + 1]);
            maxLeft = Math.max(maxLeft, nums[j]);
        }
        return ans;
    }
}