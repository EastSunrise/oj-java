package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution27;

/**
 * 283. Move Zeroes (Easy)
 *
 * @author Kingen
 * @see Solution27
 * @see <a href="https://leetcode-cn.com/problems/move-zeroes/">Move Zeroes</a>
 */
public class Solution283 implements Solution {

    /**
     * Similar to insertion sorting.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[j++] = num;
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}
