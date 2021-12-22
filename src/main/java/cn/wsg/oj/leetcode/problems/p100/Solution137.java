package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 137. Single Number II (Medium)
 *
 * @author Kingen
 * @see Solution136
 * @see Solution260
 * @see <a href="https://leetcode-cn.com/problems/single-number-ii/">Single Number II</a>
 */
public class Solution137 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
