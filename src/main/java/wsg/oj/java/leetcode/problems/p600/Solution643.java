package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 643. Maximum Average Subarray I (EASY)
 *
 * @author Kingen
 * @see Solution644
 * @see <a href="https://leetcode-cn.com/problems/maximum-average-subarray-i/">Maximum Average
 * Subarray I</a>
 * @since 2021-07-23
 */
class Solution643 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int n = nums.length;
        int max = sum;
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k];
            if (sum > max) {
                max = sum;
            }
        }
        return (double) max / k;
    }
}
