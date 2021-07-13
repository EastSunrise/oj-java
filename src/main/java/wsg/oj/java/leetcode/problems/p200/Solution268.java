package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution136;

/**
 * 268. Missing Number (Easy)
 *
 * @author Kingen
 * @see Solution41
 * @see Solution136
 * @see Solution287
 * @see Solution765
 * @see <a href="https://leetcode-cn.com/problems/missing-number/">Missing Number</a>
 * @since 2021-07-13
 */
public class Solution268 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
