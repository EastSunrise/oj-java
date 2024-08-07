package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-product-of-three-numbers/">628. Maximum Product of Three Numbers</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution152
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH, Tag.SORTING},
        difficulty = Difficulty.EASY
)
public class Solution628 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        // minimum and maximum of numbers
        int min1 = Math.min(nums[0], nums[1]), max1 = Math.max(nums[0], nums[1]);
        // minimum and maximum product of two numbers
        int min2 = nums[0] * nums[1], max2 = nums[0] * nums[1];
        int ans = Integer.MIN_VALUE;
        for (int i = 2; i < n; i++) {
            if (nums[i] < 0) {
                ans = Math.max(ans, nums[i] * min2);
                max2 = Math.max(max2, nums[i] * min1);
                min2 = Math.min(min2, nums[i] * max1);
            } else {
                ans = Math.max(ans, nums[i] * max2);
                max2 = Math.max(max2, nums[i] * max1);
                min2 = Math.min(min2, nums[i] * min1);
            }

            max1 = Math.max(max1, nums[i]);
            min1 = Math.min(min1, nums[i]);
        }
        return ans;
    }
}