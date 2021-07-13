package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 334. Increasing Triplet Subsequence (Medium)
 *
 * @author Kingen
 * @see Solution300
 * @see <a href="https://leetcode-cn.com/problems/increasing-triplet-subsequence/">Increasing
 * Triplet Subsequence</a>
 * @since 2021-07-04
 */
class Solution334 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num <= min2) {
                min2 = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
