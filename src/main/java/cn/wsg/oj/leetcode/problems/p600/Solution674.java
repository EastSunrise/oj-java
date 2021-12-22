package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 674. Longest Continuous Increasing Subsequence (EASY)
 *
 * @author Kingen
 * @see Solution673
 * @see Solution727
 * @see <a href="https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/">Longest
 * Continuous Increasing Subsequence</a>
 */
class Solution674 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int res = 1, count = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                if (count > res) {
                    res = count;
                }
                count = 1;
            }
        }
        return Math.max(res, count);
    }
}
