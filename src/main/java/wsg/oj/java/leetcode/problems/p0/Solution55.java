package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 55. Jump Game (Medium)
 *
 * @author Kingen
 * @see Solution45
 * @see Solution1306
 * @see Solution1871
 * @see <a href="https://leetcode-cn.com/problems/jump-game/">Jump Game</a>
 * @since 2021-07-11
 */
public class Solution55 implements Solution {

    /**
     * Traverses the array and update the rightmost bound that can be reached.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean canJump(int[] nums) {
        int rm = nums[0], i = 1;
        while (i <= rm && i < nums.length) {
            rm = Math.max(rm, i + nums[i]);
            i++;
        }
        return rm >= nums.length - 1;
    }
}
