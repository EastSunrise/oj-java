package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 477. Total Hamming Distance (Medium)
 *
 * @author Kingen
 * @see Solution461
 * @see <a href="https://leetcode-cn.com/problems/total-hamming-distance/">Total Hamming
 * Distance</a>
 * @since 2021-07-09
 */
class Solution477 implements Solution {

    /**
     * Counts ones and zeros bit by bit.
     *
     * @complexity T=O(32*n)
     * @complexity S=O(1)
     */
    public int totalHammingDistance(int[] nums) {
        int len = nums.length, count = 0;
        for (int i = 0; i < 31; i++) {
            int ones = 0;
            for (int j = 0; j < len; j++) {
                ones += nums[j] & 1;
                nums[j] >>>= 1;
            }
            count += ones * (len - ones);
        }
        return count;
    }
}
