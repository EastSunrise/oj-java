package cn.wsg.oj.leetcode.problems.p1500;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 1567. Maximum Length of Subarray With Positive Product (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/maximum-length-of-subarray-with-positive-product/">Maximum
 * Length of Subarray With Positive Product</a>
 */
public class Solution1567 implements Solution {

    public int getMaxLen(int[] nums) {
        // positive: the max length of positive subarray that ends with nums[i]
        // negative: the max length of negative subarray that ends with nums[i]
        int positive = 0, negative = 0, max = 0;
        for (int num : nums) {
            if (num == 0) {
                positive = negative = 0;
            } else if (num > 0) {
                positive++;
                if (negative > 0) {
                    negative++;
                }
            } else {
                int tmp = positive;
                positive = negative == 0 ? 0 : negative + 1;
                negative = tmp + 1;
            }
            max = Math.max(max, positive);
        }
        return max;
    }
}
