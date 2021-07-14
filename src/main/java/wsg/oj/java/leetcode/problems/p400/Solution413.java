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

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int start = 0, len = nums.length - 2, res = 0;
        while (start < len) {
            int dif = nums[start + 1] - nums[start];
            int end = start + 1;
            while (end <= len && nums[end + 1] - nums[end] == dif) {
                end++;
            }
            res += (end - start) * (end - start - 1) / 2;
            start = end;
        }
        return res;
    }
}
