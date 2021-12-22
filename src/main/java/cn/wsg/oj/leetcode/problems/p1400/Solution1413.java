package cn.wsg.oj.leetcode.problems.p1400;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 1413. Minimum Value to Get Positive Step by Step Sum (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/minimum-value-to-get-positive-step-by-step-sum/">Minimum
 * Value to Get Positive Step by Step Sum</a>
 */
public class Solution1413 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
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
