package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 908. Smallest Range I (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/smallest-range-i/">Smallest Range I</a>
 */
public class Solution908 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int smallestRange(int[] nums, int k) {
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            } else if (num < min) {
                min = num;
            }
        }
        min += 2 * k;
        return max > min ? max - min : 0;
    }
}
