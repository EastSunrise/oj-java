package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 553. Optimal Division (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/optimal-division/">Optimal Division</a>
 */
class Solution553 implements Solution {

    /**
     * Within the result of nums[0]/nums[1]/.../nums[n], nums[0] must be a part of  the numerator
     * and nums[1] must be a part of the denominator. So nums[0]/(nums[1]/nums[2]/.../nums[n]) =
     * nums[0]*nums[2]*nums[3]*...*nums[n]/nums[1] is the largest one.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        StringBuilder builder = new StringBuilder();
        builder.append(nums[0]);
        if (n == 1) {
            return builder.toString();
        }
        if (n == 2) {
            return builder.append('/').append(nums[1]).toString();
        }
        builder.append("/(").append(nums[1]);
        for (int i = 2; i < n; i++) {
            builder.append('/').append(nums[i]);
        }
        return builder.append(')').toString();
    }
}
