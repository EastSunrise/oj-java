package cn.kingen.oj.leetcode.problem.p2900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimum-sum-of-mountain-triplets-i/">2908. Minimum Sum of Mountain Triplets I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution15
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2367
 * @see cn.kingen.oj.leetcode.problem.p2800.Solution2873
 */
@Question(
        tags = {Tag.ARRAY},
        difficulty = Difficulty.EASY
)
public class Solution2908 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int minimumSum(int[] nums) {
        int n = nums.length;
        // minSuffix[i] is the minimum of nums[i:n-1]
        int[] minSuffix = new int[n];
        minSuffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minSuffix[i] = Math.min(minSuffix[i + 1], nums[i]);
        }

        int minPrefix = nums[0], ans = Integer.MAX_VALUE;
        for (int j = 1; j < n - 1; j++) {
            if (minPrefix < nums[j] && nums[j] > minSuffix[j + 1]) {
                ans = Math.min(ans, minPrefix + nums[j] + minSuffix[j + 1]);
            }
            minPrefix = Math.min(minPrefix, nums[j]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}