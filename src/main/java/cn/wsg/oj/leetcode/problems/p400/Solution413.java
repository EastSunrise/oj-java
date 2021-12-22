package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 413. Arithmetic Slices (Medium)
 *
 * @author Kingen
 * @see Solution446
 * @see Solution1630
 * @see <a href="https://leetcode-cn.com/problems/arithmetic-slices/">Arithmetic Slices</a>
 */
public class Solution413 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
