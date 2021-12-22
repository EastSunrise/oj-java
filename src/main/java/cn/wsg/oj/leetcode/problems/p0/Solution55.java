package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p1300.Solution1306;
import cn.wsg.oj.leetcode.problems.p1800.Solution1871;

/**
 * 55. Jump Game (Medium)
 *
 * @author Kingen
 * @see Solution45
 * @see Solution1306
 * @see Solution1871
 * @see <a href="https://leetcode-cn.com/problems/jump-game/">Jump Game</a>
 */
public class Solution55 implements Solution {

    /**
     * Traverses the array and update the rightmost bound that can be reached.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public boolean canJump(int[] nums) {
        int rm = nums[0], i = 1, n = nums.length;
        while (i <= rm && i < n) {
            rm = Math.max(rm, i + nums[i]);
            i++;
        }
        return rm >= n - 1;
    }
}
