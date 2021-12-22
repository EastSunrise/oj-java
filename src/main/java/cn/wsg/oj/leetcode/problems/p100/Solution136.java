package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution260;
import cn.wsg.oj.leetcode.problems.p200.Solution268;
import cn.wsg.oj.leetcode.problems.p200.Solution287;

/**
 * 136. Single Number (Easy)
 *
 * @author Kingen
 * @see Solution137
 * @see Solution260
 * @see Solution268
 * @see Solution287
 * @see Solution389
 * @see <a href="https://leetcode-cn.com/problems/single-number/">Single Number</a>
 */
public class Solution136 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        return sum;
    }
}
