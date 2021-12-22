package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 747. Largest Number At Least Twice of Others (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/">Largest
 * Number At Least Twice of Others</a>
 */
public class Solution747 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int dominantIndex(int[] nums) {
        int res = 0, max = nums[0], second = Integer.MIN_VALUE / 4;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
                res = i;
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return max >= second * 2 ? res : -1;
    }
}
