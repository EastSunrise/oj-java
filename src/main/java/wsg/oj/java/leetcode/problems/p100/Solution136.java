package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution260;
import wsg.oj.java.leetcode.problems.p200.Solution268;
import wsg.oj.java.leetcode.problems.p200.Solution287;

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
 * @since 2021-07-12
 */
public class Solution136 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        return sum;
    }
}
