package wsg.oj.java.leetcode.problems.p900;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 918. Maximum Sum Circular Subarray (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/maximum-sum-circular-subarray/">Maximum Sum
 * Circular Subarray</a>
 * @since 2021-07-27
 */
public class Solution918 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int maxSubarraySumCircular(int[] nums) {
        // imax: the max subarray ends with nums[i]
        int imax = 0, max = nums[0];
        // imin: the min subarray ends with nums[i]
        int imin = 0, min = nums[0], sum = 0;
        for (int num : nums) {
            imax = Math.max(num, imax + num);
            max = Math.max(max, imax);
            imin = Math.min(num, imin + num);
            min = Math.min(min, imin);
            sum += num;
        }
        // if all numbers are negative
        return max < 0 ? max : Math.max(max, sum - min);
    }
}
