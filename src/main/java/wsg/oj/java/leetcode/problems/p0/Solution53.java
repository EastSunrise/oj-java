package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 53. Maximum Subarray (Easy)
 *
 * @author Kingen
 * @see Solution121
 * @see Solution152
 * @see Solution697
 * @see Solution978
 * @see Solution1749
 * @see Solution1746
 * @see <a href="https://leetcode-cn.com/problems/maximum-subarray/">Maximum Subarray</a>
 * @since 2021-07-11
 */
public class Solution53 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int maxSubArray(int[] nums) {
        int sum = nums[0], res = nums[0], len = nums.length;
        for (int i = 1; i < len; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
