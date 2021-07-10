package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.Complexity;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 45. Jump Game II (Medium)
 *
 * @author Kingen
 * @see Solution55
 * @see Solution1306
 * @see Solution1871
 * @see <a href="https://leetcode-cn.com/problems/jump-game-ii/">Jump Game II</a>
 * @since 2021-07-10
 */
class Solution45 implements Solution {

    /**
     * Records the rightmost position that can be reached after a step.
     *
     * @see #DYNAMIC_PROGRAMMING
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int jump(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        // rm: the rightmost position that can be reached after 'step' steps
        // nrm: the next 'rm'
        int step = 0, rm = 0, nrm = nums[0], target = len - 1;
        for (int i = 1; i < len; i++) {
            if (nrm >= target) {
                return step + 1;
            }
            if (i > rm) {
                step++;
                rm = nrm;
            }
            nrm = Math.max(nrm, i + nums[i]);
        }
        throw new IllegalArgumentException("Can't reach the end of the array");
    }
}
