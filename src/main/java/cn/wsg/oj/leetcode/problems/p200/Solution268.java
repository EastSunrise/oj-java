package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p100.Solution136;

/**
 * 268. Missing Number (Easy)
 *
 * @author Kingen
 * @see Solution41
 * @see Solution136
 * @see Solution287
 * @see Solution765
 * @see <a href="https://leetcode-cn.com/problems/missing-number/">Missing Number</a>
 */
public class Solution268 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
