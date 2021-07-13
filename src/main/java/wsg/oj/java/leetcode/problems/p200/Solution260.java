package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution136;
import wsg.oj.java.leetcode.problems.p100.Solution137;

/**
 * 260. Single Number III (Medium)
 *
 * @author Kingen
 * @see Solution136
 * @see Solution137
 * @see <a href="https://leetcode-cn.com/problems/single-number-iii/">Single Number III</a>
 * @since 2021-07-13
 */
public class Solution260 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        // find the first occurrence of bit 1 from right to left
        // assume that it's the kth (from right to left) bit
        // it also means that the kth bits of the two targets are different: 1 and 0 respectively
        // then set mask=1<<(k-1)
        int mask = 1;
        while ((sum & 1) == 0) {
            sum >>= 1;
            mask <<= 1;
        }
        // divide the nums into two parts
        // one contains the number whose kth bit is 0
        // the other contains the number whose kth bit is 1
        // the two targets will be separately divided into different parts
        int sum1 = 0, sum2 = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                sum1 ^= num;
            } else {
                sum2 ^= num;
            }
        }
        return new int[]{sum1, sum2};
    }
}
