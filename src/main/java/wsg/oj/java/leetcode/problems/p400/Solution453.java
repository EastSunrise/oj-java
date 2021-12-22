package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 453. Minimum Moves to Equal Array Elements (Easy)
 *
 * @author Kingen
 * @see Solution462
 * @see <a href="https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/">Minimum
 * Moves to Equal Array Elements</a>
 * @since 2021-07-14
 */
public class Solution453 implements Solution {

    /**
     * It means decrementing one element of the array by 1 in one move.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int minMoves(int[] nums) {
        int min = nums[0], sum = 0;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        for (int num : nums) {
            sum += num - min;
        }
        return sum;
    }
}
