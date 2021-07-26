package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution27;

/**
 * 283. Move Zeroes (Easy)
 *
 * @author Kingen
 * @see Solution27
 * @see <a href="https://leetcode-cn.com/problems/move-zeroes/">Move Zeroes</a>
 * @since 2021-07-13
 */
public class Solution283 implements Solution {

    /**
     * Similar to insertion sorting.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
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
