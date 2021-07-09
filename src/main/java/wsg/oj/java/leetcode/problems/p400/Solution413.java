package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 413. Arithmetic Slices (Medium)
 *
 * @author Kingen
 * @see Solution446
 * @see Solution1630
 * @see <a href="https://leetcode-cn.com/problems/arithmetic-slices/">Arithmetic Slices</a>
 * @since 2021-07-07
 */
class Solution413 implements Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        int start = 0, end = nums.length - 1, res = 0;
        while (end - start > 1) {
            int dif = nums[start + 1] - nums[start];
            int i = start + 1;
            while (i < end && nums[i + 1] - nums[i] == dif) {
                i++;
            }
            int len = i - start + 1;
            res += (len - 1) * (len - 2) / 2;
            start = i;
        }
        return res;
    }
}
