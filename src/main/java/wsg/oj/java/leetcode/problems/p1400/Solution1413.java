package wsg.oj.java.leetcode.problems.p1400;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1413. Minimum Value to Get Positive Step by Step Sum (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/minimum-value-to-get-positive-step-by-step-sum/">Minimum
 * Value to Get Positive Step by Step Sum</a>
 * @since 2021-07-27
 */
public class Solution1413 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int minStartValue(int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }
        return Math.max(1, 1 - min);
    }
}
