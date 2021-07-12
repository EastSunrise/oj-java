package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 137. Single Number II (Medium)
 *
 * @author Kingen
 * @see Solution136
 * @see Solution260
 * @see <a href="https://leetcode-cn.com/problems/single-number-ii/">Single Number II</a>
 * @since 2021-07-12
 */
class Solution137 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int singleNumber(int[] nums) {
        // x->(x,0)->(0,x)->(0,0)
        int a = 0, b = 0;
        for (int num : nums) {
            a = (num ^ a) & ~b;
            b = (num ^ b) & ~a;
        }
        return a;
    }
}
