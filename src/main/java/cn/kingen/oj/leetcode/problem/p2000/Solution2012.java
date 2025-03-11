package cn.kingen.oj.leetcode.problem.p2000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/sum-of-beauty-in-the-array/">2012. Sum of Beauty in the Array</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution121
 * @see cn.kingen.oj.leetcode.problem.p900.Solution915
 * @see cn.kingen.oj.leetcode.problem.p2800.Solution2874

 */
@Question(
        tags = {Tag.ARRAY},
        difficulty = Difficulty.MEDIUM,
        date = "2025-03-11"
)
public class Solution2012 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] flags = new int[n];
        int leftMax = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > leftMax) {
                flags[i] = 2;
            }
            leftMax = Math.max(leftMax, nums[i]);
        }
        int rightMin = nums[n - 1];
        int ans = 0;
        for (int i = n - 2; i >= 1; i--) {
            if (flags[i] == 2 && nums[i] < rightMin) {
                ans += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                ans++;
            }
            rightMin = Math.min(rightMin, nums[i]);
        }
        return ans;
    }
}