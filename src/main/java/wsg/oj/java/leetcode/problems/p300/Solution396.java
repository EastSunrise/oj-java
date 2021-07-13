package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 396. Rotate Function (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/rotate-function/">Rotate Function</a>
 * @since 2021-07-06
 */
class Solution396 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int maxRotateFunction(int[] nums) {
        int sum = 0, f = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += nums[i] * i;
        }
        int res = f;
        for (int i = n - 1; i >= 0; i--) {
            f = f - nums[i] * n + sum;
            res = Math.max(res, f);
        }
        return res;
    }
}
