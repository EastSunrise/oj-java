package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.Solution;

/**
 * 334. Increasing Triplet Subsequence (Medium)
 *
 * @author Kingen
 * @see Solution300
 * @see <a href="https://leetcode-cn.com/problems/increasing-triplet-subsequence/">Increasing
 * Triplet Subsequence</a>
 * @since 2021-07-04
 */
class Solution334 extends Solution {

    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        int i = 1;
        while (i < len && nums[i - 1] >= nums[i]) {
            i++;
        }
        if (i == len) {
            return false;
        }
        // find the first pair of numbers with increasing order
        int min = nums[i - 1], min2 = nums[i];
        while (++i < len) {
            if (nums[i - 1] < nums[i]) {
                // find next pair of numbers with increasing order
                if (nums[i] > min2 || nums[i - 1] > min) {
                    return true;
                }
                min = nums[i - 1];
                min2 = nums[i];
            } else {
                if (nums[i] > min) {
                    min2 = nums[i];
                }
            }
        }
        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
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
